package Programmers.ETC;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근_지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            pq.offer(work);
        }
        for(int i = 0 ; i < n ; i++){
            int num = pq.poll();
            if(num > 0){
                num--;
            }
            pq.offer(num);
        }

        while(!pq.isEmpty()){
            int num = pq.poll();
            answer += num * num;
        }
        return answer;
    }
}
