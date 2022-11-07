package Programmers.ETC;

public class OX퀴즈 {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0 ; i < quiz.length ; i++){
            answer[i] = cal(quiz[i]);
        }
        return answer;
    }
    private static final String PLUS = "+";
    private static final String MINUS = "-";

    private static final String RIGHT = "O";
    private static final String WRONG = "X";
    private String cal(String str){
        String[] temp = str.split(" ");
        int num1 = Integer.parseInt(temp[0]);
        int num2 = Integer.parseInt(temp[2]);
        int result = 0;
        if(PLUS.equals(temp[1])){
            result = num1 + num2;
        }else{
            result = num1 - num2;
        }
        int num3 = Integer.parseInt(temp[4]);
        if(num3 == result){
            return RIGHT;
        }else{
            return WRONG;
        }
    }
}
