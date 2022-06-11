package Programmers.ETC;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] numberCnt = new int[10];
        int max = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < priorities.length ; i++){
            q.offer(new int[] {i,priorities[i]});
            max = Math.max(max,priorities[i]);
            numberCnt[priorities[i]]++;
        }
        System.out.println(max);
        while(true){
            int[] now = q.poll();
            if(now[1] == max){
                answer++;
                if(now[0] == location){
                    break;
                }
                if(--numberCnt[max] == 0){
                    max = findNextMax(numberCnt,max);
                }
            }else{
                q.offer(now);
            }
        }
        return answer;
    }
    private int findNextMax(int[] numberCnt , int max){
        for(int i = max ; i > 0 ; i--){
            if(numberCnt[i] != 0){
                return i;
            }
        }
        return 0;
    }
}
