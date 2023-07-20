package Programmers.ETC;

import java.util.Deque;
import java.util.LinkedList;

public class 짝지어_제거하기2 {
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;
    public int solution(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0 ; i < s.length() ; i++){
            char now = s.charAt(i);
            if(!stack.isEmpty() && stack.peekFirst() == now){
                stack.pop();
                continue;
            }
            stack.push(now);
        }
        if(stack.isEmpty()){
            return SUCCESS;
        }
        return FAIL;
    }
}
