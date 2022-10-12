package Programmers.ETC;

import java.util.Arrays;

public class 문자열_내_마음대로_정렬하기 {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        Arrays.sort(strings,(o1,o2)->{
            if(o1.charAt(n) == o2.charAt(n)){
                return o1.compareTo(o2);
            }
            return o1.charAt(n) - o2.charAt(n);
        });
        answer = strings;
        return answer;
    }
}
