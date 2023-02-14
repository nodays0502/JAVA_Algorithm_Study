package Programmers.ETC;

import java.util.PriorityQueue;

public class 명예의_전당 {
    public int[] solution(int k, int[] scores) {
        int[] answer = new int[scores.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            return o1-o2;
        });
        int index = 0;
        for(int score : scores){
            pq.offer(score);
            if(pq.size() > k){
                pq.poll();
            }
            answer[index++] = pq.peek();
        }
        return answer;
    }
}
