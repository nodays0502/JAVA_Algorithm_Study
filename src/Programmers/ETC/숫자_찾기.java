package Programmers.ETC;

public class 숫자_찾기 {
    private static final int NOT_FOUND = -1;
    public int solution(int num, int k) {
        int answer = NOT_FOUND;
        String str = Integer.toString(num);
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if( (ch - '0') == k){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}
