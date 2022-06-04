package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 점프와_순간_이동 {
    public int solution(int n) {
        int ans = divide(n);
        return ans;
    }
    private int divide(int n){
        int result = 0;
        while(n > 0){
            if(n % 2 != 0){
                result++;
            }
            n /= 2;
        }
        return result;
    }
    private int bfs(int target){
        Map<Integer,Integer> visited = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return o1[1] - o2[1];
        });
        pq.offer(new int[] {0,0});
        visited.put(0,0);
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[0] == target){
                return now[1];
            }
            int next = 2 * now[0];
            int time = now[1];
            if(next > 0 && (!visited.containsKey(next) || visited.get(next) > time) ){
                visited.put(next,time);
                pq.offer(new int[] {next,time});
            }
            next = now[0]+1;
            time = now[1]+1;
            if(next > 0 && (!visited.containsKey(next) || visited.get(next) > time) ){
                visited.put(next,time);
                pq.offer(new int[] {next,time});
            }
        }
        return -1;
    }
}
