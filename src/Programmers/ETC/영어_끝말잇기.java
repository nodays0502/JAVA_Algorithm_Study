package Programmers.ETC;

import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        char prev = '0';
        Set<String> used = new HashSet<>();
        for(int i = 0 ; i < words.length ; i++){
            String word = words[i];
            if(i != 0 && !check(word,used,prev)){
                answer = new int[] {i %n +1, i / n +1};
                break;
            }
            used.add(word);
            prev = word.charAt(word.length()-1);
        }
        return answer;
    }
    private static boolean check(String word,Set<String> used,char prev){
        if(used.contains(word)){
            return false;
        }
        if(word.charAt(0) != prev){
            return false;
        }
        return true;
    }
}
