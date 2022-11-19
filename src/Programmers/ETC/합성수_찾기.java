package Programmers.ETC;

public class 합성수_찾기 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 3 ; i <= n ; i++){
            if(isRight(i)){
                answer++;
            }
        }
        return answer;
    }
    private static boolean isRight(int num){
        int cnt = 0;
        for(int i = 1 ; i <= num ; i++){
            if(num % i == 0){
                cnt++;
            }
            if(cnt >= 3){
                return true;
            }
        }
        return false;
    }
}
