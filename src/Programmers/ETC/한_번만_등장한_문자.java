package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;

public class 한_번만_등장한_문자 {
    public String solution(String s) {
        String answer = "";
        Map<Character,Integer> cnt = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            cnt.merge(ch,1,(v1,v2)-> v1+1);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch = 'a' ; ch <= 'z' ; ch++){
            if(cnt.getOrDefault(ch,0) == 1){
                sb.append(ch);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
