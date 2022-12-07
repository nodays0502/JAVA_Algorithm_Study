package Programmers.ETC;

public class 문자열안에_문자열 {
    private static final int FIND = 1;
    private static final int NOT_FOUND = 2;
    public int solution(String str1, String str2) {
        int answer = 0;
        if(str1.indexOf(str2) >= 0){
            answer = FIND;
        }else{
            answer = NOT_FOUND;
        }
        return answer;
    }
}
