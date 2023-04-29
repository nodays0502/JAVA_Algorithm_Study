package Programmers.ETC;

import java.util.Collections;
import java.util.PriorityQueue;

public class 디펜스_게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int sum = 0;
        for(int num : enemy){
            answer++;
            pq.offer(num);
            sum += num;
            if(sum > n && cnt < k){
                int temp = pq.poll();
                sum -= temp;
                cnt++;
                continue;
            }
            if(sum > n){
                answer--;
                break;
            }
        }
        return answer;
    }
}
