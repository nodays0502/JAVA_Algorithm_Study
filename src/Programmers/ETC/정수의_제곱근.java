package Programmers.ETC;

public class 정수의_제곱근 {
    private static final int NOT_FOUND = -1;
    public long solution(long n) {
        long answer = NOT_FOUND;
        long num = (long)Math.sqrt(n);
        if(n == num * num){
            answer = (num+1) * (num+1);
        }
        return answer;
    }
}
