package Programmers.ETC;

public class 분수의_덧셈 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        numer1 *= denom2;
        numer2 *= denom1;
        int denom = denom1 * denom2;
        int numer = numer1 + numer2;
        for(int i = Math.max(numer,denom) ; i >= 2; i--){
            if(denom % i == 0 && numer % i == 0){
                denom /= i;
                numer /= i;
            }
        }
        answer = new int[]{numer,denom};
        return answer;
    }
}
