package Programmers.ETC;

import java.util.Deque;
import java.util.LinkedList;

public class 짝지어_제거하기 {
    public int solution(String s) {
        int answer = check(s);
        return answer;
    }
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;
    private int check(String s){
        int time = 0;
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0 ; i < s.length() ; i++){
            char now = s.charAt(i);
            // System.out.println(now+" "+stack);
            if(!stack.isEmpty() && stack.peekLast() == now){
                stack.pollLast();
                continue;
            }
            stack.add(now);
        }

        if(stack.isEmpty()){
            return SUCCESS;
        }
        return FAIL;
    }
}
