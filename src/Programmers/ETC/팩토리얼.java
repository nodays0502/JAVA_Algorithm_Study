package Programmers.ETC;

public class 팩토리얼 {
    private static final int INF = 3_628_800;
    public int solution(int n) {
        int answer = cal(n);

        return answer;
    }
    private int cal(int num){
        int result = 1;
        int temp = 1;
        for(int i = 1 ; i <= 10 ; i++){
            temp *= i;
            if(temp <= num){
                result = i;
            }else{
                break;
            }
        }
        return result;
    }
}
