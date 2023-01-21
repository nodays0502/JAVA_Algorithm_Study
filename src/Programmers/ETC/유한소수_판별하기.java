package Programmers.ETC;

public class 유한소수_판별하기 {
    private static final int FINITE_DECIMAL = 1;
    private static final int INFINITE_DECIMAL = 2;
    public int solution(int a, int b) {
        int answer = INFINITE_DECIMAL;
        for(int i = Math.max(a,b) ; i >= 2 ; i--){
            if(a % i == 0 && b % i == 0){
                a /= i;
                b /= i;
            }
        }
        if(detectFiniteDeciaml(b)){
            answer = FINITE_DECIMAL;
        }
        return answer;
    }
    private static boolean detectFiniteDeciaml(int num){
        while(num > 1){
            if(num % 2 == 0){
                num /= 2;
            }else if(num % 5 == 0){
                num /= 5;
            }else{
                return false;
            }
        }
        return true;
    }
}
