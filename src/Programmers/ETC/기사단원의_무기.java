package Programmers.ETC;

public class 기사단원의_무기 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1 ; i <= number ; i++){
            int cnt = countDivisor(i);
            if(cnt > limit){
                answer += power;
            }else{
                answer += cnt;
            }
        }
        return answer;
    }
    private int countDivisor(int number){
        int result = 0;
        for(int i = 1 ; i <= Math.sqrt(number) ; i++){
            if(i * i == number){
                result++;
            }else if(number % i == 0){
                result += 2;
            }
        }
        return result;
    }
}
