package Programmers.ETC;

import java.util.PriorityQueue;

public class 상담원_인원 {
    public int solution(int k, int n, int[][] reqs) {
        int[] people = new int[k];
        int answer = cal(0,n,k,people,reqs);
        return answer;
    }
    private static final int INF = 987654321;
    private static int cal(int depth, int n, int k,int[] people, int[][] reqs){
        if(depth == k && n == 0){
            return calWaitTime(people,k,reqs);
        }
        if(depth == k){
            return INF;
        }
        int result = INF;
        for(int i = 1 ; i <= n ; i++){
            people[depth] = i;
            result = Math.min(result,cal(depth+1,n-i,k,people,reqs));
        }
        return result;
    }
    private static int calWaitTime(int[] people, int k, int[][] reqs){
        int waitTime = 0;
        PriorityQueue<Integer>[] q = new PriorityQueue[k];
        for(int i = 0 ; i < k ; i++){
            q[i] = new PriorityQueue<>();
        }
        for(int[] req : reqs){
            int startTime = req[0];
            int duringTime = req[1];
            int type = req[2] - 1;
            int time = startTime;
            if(q[type].size() >= people[type]){
                int endTime = q[type].poll();
                if(endTime > startTime){
                    waitTime += endTime - startTime;
                    time = endTime;
                }
            }
            q[type].add(time + duringTime);
        }
        return waitTime;
    }
}
