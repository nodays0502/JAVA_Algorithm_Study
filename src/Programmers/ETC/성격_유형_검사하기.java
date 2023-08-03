package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {
    private static final int HALF_SCORE = 4;
    private static final char[][] CHARACTER = {{'R','T'},
        {'C','F'},
        {'J','M'},
        {'A','N'}};
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character,Integer> sumScore = new HashMap<>();
        for(int i = 0 ; i < survey.length ; i++){
            String s = survey[i];
            int score = choices[i];
            char a = s.charAt(0);
            char b = s.charAt(1);
            if(score < HALF_SCORE){
                sumScore.merge(a,Math.abs(score - HALF_SCORE), (v1,v2)->{
                    return v1 + Math.abs(score - HALF_SCORE);
                });
            }
            if(score > HALF_SCORE){
                sumScore.merge(b,Math.abs(score - HALF_SCORE), (v1,v2)->{
                    return v1 + Math.abs(score - HALF_SCORE);
                });
            }
        }
        for(char[] chArray : CHARACTER){
            int firstScore = sumScore.getOrDefault(chArray[0], 0);
            int secondScore = sumScore.getOrDefault(chArray[1], 0);
            // System.out.println(Arrays.toString(chArray)+" "+firstScore+","+secondScore);
            if(firstScore >= secondScore){
                answer += chArray[0];
            }else{
                answer += chArray[1];
            }
        }
        return answer;
    }
}
