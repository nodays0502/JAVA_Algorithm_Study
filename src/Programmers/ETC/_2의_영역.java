package Programmers.ETC;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _2의_영역 {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> index = new LinkedList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 2){
                index.add(i);
            }
        }
        if(index.size() == 0){
            return new int[]{-1};
        }
        int startIndex = index.get(0);
        int endIndex = index.get(index.size()-1);
        answer = Arrays.copyOfRange(arr,startIndex,endIndex+1);
        return answer;
    }
}
