package Programmers.ETC;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        Arrays.fill(answer,-1);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = size - 1 ; i >= 0 ; i--){
            if(stack.isEmpty()){
                stack.push(numbers[i]);
                continue;
            }
            if(numbers[i] < stack.peek()){
                answer[i] = stack.peek();
                stack.push(numbers[i]);
            }else{
                while(!stack.isEmpty() && numbers[i] >= stack.peek()){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    answer[i] = stack.peek();
                    stack.push(numbers[i]);
                }
            }
            stack.push(numbers[i]);
        }
        return answer;
    }
}
