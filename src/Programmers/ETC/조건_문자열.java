package Programmers.ETC;

public class 조건_문자열 {
    private static final int TRUE = 1;
    private static final int FALSE = 0;
    public int solution(String ineq, String eq, int n, int m) {
        int answer = FALSE;
        if(ineq.equals(">") && eq.equals("=") && n >= m){
            answer = TRUE;
        }
        if(ineq.equals(">") && eq.equals("!") && n > m){
            answer = TRUE;
        }
        if(ineq.equals("<") && eq.equals("=") && n <= m){
            answer = TRUE;
        }
        if(ineq.equals("<") && eq.equals("!") && n < m){
            answer = TRUE;
        }
        return answer;
    }
}
