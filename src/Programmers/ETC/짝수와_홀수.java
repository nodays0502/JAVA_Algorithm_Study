package Programmers.ETC;

public class 짝수와_홀수 {
    private static final String ODD = "Odd";
    private static final String EVEN = "Even";
    public String solution(int num) {
        if(num % 2 == 0){
            return EVEN;
        }else{
            return ODD;
        }
    }
}
