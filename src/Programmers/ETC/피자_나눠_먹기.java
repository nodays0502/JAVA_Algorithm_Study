package Programmers.ETC;

public class 피자_나눠_먹기 {
    public int solution(int n) {
        int answer = 0;
        answer = n / 7;
        if(answer * 7 < n){
            answer++;
        }
        return answer;
    }
}
