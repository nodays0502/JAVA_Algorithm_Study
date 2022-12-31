package Programmers.ETC;

public class 피자_나눠_먹기_2 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            while(true){
                answer++;
                if( (answer * 6) % n == 0){
                    break;
                }
            }
            return answer;
        }
    }
}
