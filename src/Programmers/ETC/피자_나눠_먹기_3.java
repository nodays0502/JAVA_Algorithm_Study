package Programmers.ETC;

public class 피자_나눠_먹기_3 {
    public int solution(int slice, int n) {
        int answer = 0;
        while(true){
            if(answer * slice >= n){
                break;
            }
            answer++;
        }
        return answer;
    }
}
