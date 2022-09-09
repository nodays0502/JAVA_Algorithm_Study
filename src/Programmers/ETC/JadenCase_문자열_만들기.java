package Programmers.ETC;

public class JadenCase_문자열_만들기 {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(isFirst && Character.isLowerCase(ch)){
                ch = Character.toUpperCase(ch);
            }
            if(!isFirst && Character.isUpperCase(ch)){
                ch = Character.toLowerCase(ch);
            }
            if(isFirst){
                isFirst = false;
            }
            sb.append(ch);
            if(ch == ' '){
                isFirst = true;
            }
        }
        answer = sb.toString();
        return answer;
    }
}
