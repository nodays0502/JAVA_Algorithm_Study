package Programmers.ETC;

public class 롤케이크_자르기 {
    private static final int SIZE = 10_000;
    public int solution(int[] topping) {
        int answer = 0;
        int[][] numCnt = new int[2][10_000+1];
        int[] cnt = new int[2];
        for(int i = 0 ; i < topping.length ; i++){
            if(numCnt[1][topping[i]] == 0){
                cnt[1]++;
            }
            numCnt[1][topping[i]]++;
        }
        for(int i = 0 ; i < topping.length ; i++){
            if(numCnt[0][topping[i]] == 0){
                cnt[0]++;
            }
            numCnt[0][topping[i]]++;
            numCnt[1][topping[i]]--;
            if(numCnt[1][topping[i]] == 0){
                cnt[1]--;
            }
            if(cnt[0] == cnt[1]){
                answer++;
            }
        }
        return answer;
    }
}
