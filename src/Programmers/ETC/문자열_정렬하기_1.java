package Programmers.ETC;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 문자열_정렬하기_1 {
    public int[] solution(String my_string) {
        int[] answer = {};
        List<Integer> numbers = new LinkedList<>();
        for(int i = 0 ; i< my_string.length() ; i++){
            char ch = my_string.charAt(i);
            if(ch >= '0' && ch <= '9'){
                numbers.add(ch-'0');
            }
        }
        Collections.sort(numbers);
        answer = new int[numbers.size()];
        for(int i = 0 ; i < numbers.size() ; i++){
            answer[i] = numbers.get(i);
        }
        return answer;
    }
}
