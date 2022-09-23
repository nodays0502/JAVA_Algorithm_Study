package Programmers.PCCP_모의고사_1;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class NO_1 {
    private static final String NOT_FOUND = "N";
    public String solution(String input_string) {
        String answer = "";
        int size = input_string.length();
        Set<Character> set = new HashSet<>();
        Set<Character> used = new HashSet<>();
        List<Character> result = new LinkedList<>();
        for(int i = 0 ; i < size ; i++){
            char ch = input_string.charAt(i);
            if(set.contains(ch) && i > 0 && input_string.charAt(i-1) != ch && !used.contains(ch)){
                result.add(ch);
                used.add(ch);
            }
            set.add(ch);
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for(char ch : result){
            sb.append(ch);
        }
        answer = sb.toString();
        if(sb.length() == 0){
            answer = NOT_FOUND;
        }
        return answer;
    }
}
