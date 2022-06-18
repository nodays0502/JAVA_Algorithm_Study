package Programmers.ETC;

public class 올바른_괄호 {
    boolean solution(String s) {
        boolean answer = checkBracket(s);
        return answer;
    }
    private boolean checkBracket(String s){
        int size = s.length();
        int cnt = 0;
        for(int i = 0 ; i < size ; i++){
            char now = s.charAt(i);
            if(now == '('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt < 0){
                return false;
            }
        }
        if(cnt != 0){
            return false;
        }
        return true;
    }
}
