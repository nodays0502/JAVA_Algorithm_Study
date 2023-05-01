package Programmers.ETC;

import java.util.Collections;
import java.util.PriorityQueue;

public class 혼자_놀기의_달인 {
    public int solution(int[] cards) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int size = cards.length;
        boolean[] used = new boolean[size];
        for(int i = 0 ; i < size ; i++){
            if(!used[i]){
                int cnt = cal(i,used,cards);
                pq.offer(cnt);
            }
        }
        if(pq.size() < 2){
            return 0;
        }
        answer = pq.poll();
        answer *= pq.poll();
        return answer;
    }
    private static int cal(int index, boolean[] used, int[] cards){
        int cnt = 0;
        while(!used[index]){
            used[index] = true;
            index = cards[index]-1;
            cnt++;
        }
        return cnt;
    }
}
