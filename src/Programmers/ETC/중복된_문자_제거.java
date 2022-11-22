package Programmers.ETC;

import java.util.HashSet;
import java.util.Set;

public class 중복된_문자_제거 {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Set<Character> check = new HashSet<>();
        for(int i = 0 ; i < my_string.length() ; i++){
            char ch = my_string.charAt(i);
            if(!check.contains(ch)){
                check.add(ch);
                sb.append(ch);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
