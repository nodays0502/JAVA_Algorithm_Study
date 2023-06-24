package Programmers.ETC;

public class 문자열_겹쳐쓰기 {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append(my_string.substring(0,s));
        sb.append(overwrite_string);
        int size = my_string.length() - overwrite_string.length();
        sb.append(my_string.substring(s + overwrite_string.length(),my_string.length()));
        // System.out.println(sb.toString());
        answer = sb.toString();
        return answer;
    }
}
