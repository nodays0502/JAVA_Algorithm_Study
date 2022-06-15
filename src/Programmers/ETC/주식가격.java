package Programmers.ETC;

import java.util.ArrayDeque;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        int upLength = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < size ; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int index = stack.poll();
                answer[index] = i -index;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index = stack.poll();
            answer[index] = size -1 -index;
        }

        return answer;
    }
}
