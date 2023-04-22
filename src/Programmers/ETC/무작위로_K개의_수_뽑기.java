package Programmers.ETC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 무작위로_K개의_수_뽑기 {
    private static final int NOT_FOUND = -1;
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer,NOT_FOUND);
        Set<Integer> used = new HashSet<>();
        int index = 0;
        for(int num : arr){
            if(!used.contains(num)){
                answer[index++] = num;
                used.add(num);
            }
            if(index >= k){
                break;
            }
        }
        return answer;
    }
}
