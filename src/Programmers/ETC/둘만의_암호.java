package Programmers.ETC;

import java.util.HashSet;
import java.util.Set;

public class 둘만의_암호 {
    private static final int SIZE = 26;
    public String solution(String s, String skip, int index) {
        String answer = "";
        Set<Character> skipAlpha = new HashSet<>();
        for(int i = 0 ; i < skip.length() ; i++){
            char ch = skip.charAt(i);
            skipAlpha.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            char next = jump(ch,index,skipAlpha);
            sb.append(next);
        }
        answer = sb.toString();
        return answer;
    }
    private static char jump(char ch, int index, Set<Character> skipAlpha){
        while(index > 0){
            ch++;
            if(ch >'z'){
                ch = 'a';
            }
            if(skipAlpha.contains(ch)){
                continue;
            }
            index--;
        }
        return ch;
    }
}
