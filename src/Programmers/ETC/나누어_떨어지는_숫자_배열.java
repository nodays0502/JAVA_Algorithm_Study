package Programmers.ETC;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 나누어_떨어지는_숫자_배열 {
    private static final int NOT_FOUND = -1;
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> result = new LinkedList<>();
        Arrays.sort(arr);
        for(int num : arr){
            if(num % divisor == 0){
                result.add(num);
            }
        }
        if(result.size() == 0){
            result.add(NOT_FOUND);
        }
        answer = new int[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
