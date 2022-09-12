package Programmers.ETC;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = cal(brown,yellow);
        return answer;
    }
    private static final int INF = 987654321;
    private static int[] cal(int brown, int yellow){
        int sum = brown + yellow;
        for(int i = 3 ; i < INF; i++){
            for(int j = i ; j < INF; j++){
                int mul = i*j;
                if(mul == sum && 2 * i + 2 * j - 4 == brown ){
                    return new int[] {j,i};
                }else if(mul > sum || mul < 0){
                    break;
                }
            }
        }
        return new int[] {0,0};
    }

}
