package Programmers.ETC;

public class 숨어있는_숫자의_덧셈_2 {
    public int solution(String my_string) {
        int answer = 0;
        int num = 0;
        for(int i = 0 ; i < my_string.length() ; i++){
            char ch = my_string.charAt(i);
            if(ch >= '0' && ch <= '9' ){
                num *= 10;
                num += ch - '0';
            }else{
                answer += num;
                num = 0;
            }
        }
        answer += num;
        return answer;
    }
}
