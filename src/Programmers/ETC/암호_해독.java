package Programmers.ETC;

public class 암호_해독 {
    public String solution(String cipher, int code) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = code-1 ; i < cipher.length() ; i += code){
            sb.append(cipher.charAt(i));
        }
        answer = sb.toString();
        return answer;
    }
}
