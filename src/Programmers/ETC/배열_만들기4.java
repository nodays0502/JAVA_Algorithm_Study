package Programmers.ETC;

import java.util.Deque;
import java.util.LinkedList;

public class 배열_만들기4 {
    public int[] solution(int[] arr) {
        int[] stk = cal(arr);
        return stk;
    }
    private static int[] cal(int[] arr){
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        while(i < arr.length){
            int num = arr[i];
            if(deque.isEmpty() || deque.peekLast() < num){
                deque.offerLast(num);
                i++;
                continue;
            }
            if(deque.peekLast() >= num){
                deque.pollLast();
            }
        }
        int[] result = new int[deque.size()];
        for(int j = 0 ; j < result.length ; j++){
            result[j] = deque.pollFirst();
        }
        return result;
    }
}
