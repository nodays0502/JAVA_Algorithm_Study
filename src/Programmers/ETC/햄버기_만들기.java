package Programmers.ETC;

import java.util.Deque;
import java.util.LinkedList;

public class 햄버기_만들기 {
    public int solution(int[] ingredient) {
        int answer = 0;
        Deque<Integer> q = new LinkedList<>();
        for(int num : ingredient){
            q.offer(num);
            if(num == 1 && q.size() >= 4){

                int[] temp = new int[4];
                for(int i = 3 ; i >= 0 ; i--){
                    temp[i] = q.pollLast();
                }
                if(temp[0] == 1 && temp[1] == 2 && temp[2] == 3 && temp[3] == 1){
                    answer++;
                    continue;
                }
                for(int i = 0 ; i < 4 ; i++){
                    q.offer(temp[i]);
                }
            }
        }
        return answer;
    }
}
