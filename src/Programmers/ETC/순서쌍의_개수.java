package Programmers.ETC;

public class 순서쌍의_개수 {
    public int solution(int n) {
        int answer = cal(n);
        return answer;
    }
    private int cal(int num){
        int result = 0;
        for(int i = 1; i <= num ; i++){
            if(num % i == 0){
                result++;
            }
        }
        return result;
    }
}
