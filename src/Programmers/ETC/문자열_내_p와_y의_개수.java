package Programmers.ETC;

public class 문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        boolean answer = isSame(s);

        return answer;
    }
    private static boolean isSame(String s){
        int pCnt = 0;
        int yCnt = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == 'P' || ch == 'p'){
                pCnt++;
            }
            if(ch == 'Y' || ch == 'y'){
                yCnt++;
            }
        }
        if(pCnt == yCnt){
            return true;
        }
        return false;
    }
}
