package Programmers.ETC;

public class 콜라_문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(true){
            if(n < a){
                break;
            }
            int div = n / a;
            int temp = n % a;
            answer += div * b;
            n = div * b + temp;
        }
        return answer;
    }
}
