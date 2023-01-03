package Programmers.ETC;

public class 문자열_계산하기 {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    public int solution(String my_string) {
        int answer = 0;
        String[] temp = my_string.split(" ");
        answer = Integer.parseInt(temp[0]);
        for(int i = 1 ; i < temp.length ; i += 2){
            int num = Integer.parseInt(temp[i+1]);
            char oper = temp[i].charAt(0);
            if(oper == PLUS){
                answer += num;
            }else{
                answer -= num;
            }
        }
        return answer;
    }
}
