package Programmers.ETC;

public class 소수_찾기_LEVEL_1 {
    public int solution(int n) {
        int answer = 0;
        for(int num = 1; num <= n ; num++){
            if(checkPrime(num)){
                // System.out.println(num);
                answer++;
            }
        }
        return answer;
    }
    private boolean checkPrime(int num){
        if(num == 1){
            return false;
        }
        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
