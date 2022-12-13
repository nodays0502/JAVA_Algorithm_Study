package Programmers.ETC;

public class 문자_반복_출력하기 {
    public String solution(String my_string, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < my_string.length() ; i++){
            char ch = my_string.charAt(i);
            for(int j = 0 ; j < n ; j++){
                sb.append(ch);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
