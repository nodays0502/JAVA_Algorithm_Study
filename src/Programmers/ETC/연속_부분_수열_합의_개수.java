package Programmers.ETC;

import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> num = new HashSet<>();
        int size = elements.length;
        for(int length = 1 ; length <= size ; length++){
            for(int start = 0 ; start < size ; start++){
                int sum = 0;
                int index = start;
                for(int i = 0 ; i < length ; i++){
                    sum += elements[index];
                    index++;
                    if(index >= size){
                        index = 0;
                    }
                }
                num.add(sum);
            }
        }
        answer = num.size();
        return answer;
    }
}
