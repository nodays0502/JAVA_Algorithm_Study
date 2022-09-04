package Programmers.ETC;

public class 문자열_다루기 {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6){
            return false;
        }
        for(int i = 0 ; i < s.length() ; i++){
            char now = s.charAt(i);
            if((now >= '0' && now <= '9')){
                continue;
            }
            answer = false;
            break;
        }
        return answer;
    }
}
