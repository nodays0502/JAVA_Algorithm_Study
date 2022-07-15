package Programmers.ETC;

import java.util.Arrays;

public class 문자열_내림차순으로_배치하기 {
    public String solution(String s) {
        String answer = "";
        Character[] chArr = new Character[s.length()];
        for(int i = 0 ; i < s.length() ; i++){
            chArr[i] = s.charAt(i);
        }
        Arrays.sort(chArr,(o1,o2)->{
            int o1Num = o1 - 'a';
            int o2Num = o2 - 'a';
            if(Character.isUpperCase(o1)){
                o1Num = o1Num - 'A';
            }
            if(Character.isUpperCase(o2)){
                o2Num = o2Num - 'A';
            }
            return o2Num - o1Num;
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < chArr.length ; i++){
            sb.append(chArr[i]);
        }
        answer = sb.toString();
        return answer;
    }
}
