package Programmers.ETC;

public class 이상한_문자_만들기 {
    public String solution(String s) {
        String answer = "";
        int num = 1;
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for(int i = 0 ; i < s.length() ; i++){
            char now = s.charAt(i);
            if(now == ' '){
                sb.append(' ');
                num = 1;
                continue;
            }
            if(num % 2 == 0){
                sb.append(now);
            }else{
                char temp = (char)(now + 'A' - 'a');
                sb.append(temp);
            }
            num++;
        }
        answer = sb.toString();
        return answer;
    }
}
