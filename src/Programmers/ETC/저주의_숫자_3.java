package Programmers.ETC;

public class 저주의_숫자_3 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1 ; i <= n ; i++){
            answer++;
            while(Integer.toString(answer).indexOf('3') >= 0 || answer % 3 == 0){
                answer++;
            }

        }
        return answer;
    }
}
