package Programmers.ETC;

public class 대문자와_소문 {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < my_string.length() ; i++){
            char ch = my_string.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                sb.append( (char)(ch + ('A' - 'a')) );
            }else{
                sb.append( (char)(ch - ('A' - 'a')) );
            }
        }
        answer = sb.toString();
        return answer;
    }
}
