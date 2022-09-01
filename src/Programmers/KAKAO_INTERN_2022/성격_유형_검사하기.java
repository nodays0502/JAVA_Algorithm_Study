package Programmers.KAKAO_INTERN_2022;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {
    private static final char[][] PERSONALITY_TYPE = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
    private static final int HALF_SCORE = 4;
    public String solution(String[] survey, int[] choices) {
        Map<Character,Integer> score = new HashMap<>();
        for(int i = 0 ; i < survey.length ; i++){
            String str = survey[i];
            int choice = choices[i];
            cal(score,str,choice);
        }
        String answer = "";
        answer = makeResult(score);
        return answer;
    }
    private static String makeResult(Map<Character,Integer> score) {
        StringBuilder sb = new StringBuilder();
        for(char[] chArray : PERSONALITY_TYPE){
            int prevScore = score.getOrDefault(chArray[0], 0);
            int nextScore = score.getOrDefault(chArray[1], 0);
            if(prevScore >= nextScore){
                sb.append(chArray[0]);
            }else{
                sb.append(chArray[1]);
            }
        }
        return sb.toString();
    }
    private static void cal(Map<Character,Integer> score, String str,int choice){
        char prev = str.charAt(0);
        char next = str.charAt(1);
        int nowScore = choice - HALF_SCORE;
        if(nowScore < 0){
            score.merge(str.charAt(0),Math.abs(nowScore),(v1,v2)-> v1 + Math.abs(nowScore));
        }else if(nowScore > 0){
            score.merge(str.charAt(1),Math.abs(nowScore),(v1,v2)-> v1 + Math.abs(nowScore));
        }
    }
}
