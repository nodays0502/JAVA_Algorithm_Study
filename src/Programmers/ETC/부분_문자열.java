package Programmers.ETC;

public class 부분_문자열 {
    private static final int NOT_FOUND = -1;
    private static final int FIND = 1;
    public int solution(String str1, String str2) {
        int answer = 0;
        if(str2.indexOf(str1) != NOT_FOUND){
            answer = FIND;
        }
        return answer;
    }
}
