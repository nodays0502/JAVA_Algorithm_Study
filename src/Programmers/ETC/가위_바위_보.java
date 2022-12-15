package Programmers.ETC;

public class 가위_바위_보 {
    private static final char ROCK = '0';
    private static final char SCISSOR = '2';
    private static final char PAPER = '5';
    public String solution(String rsp) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < rsp.length() ; i++){
            char ch = rsp.charAt(i);
            if(ch == ROCK){
                sb.append(PAPER);
            }else if(ch == SCISSOR){
                sb.append(ROCK);
            }else{
                sb.append(SCISSOR);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
