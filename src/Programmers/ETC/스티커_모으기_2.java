package Programmers.ETC;

public class 스티커_모으기_2 {
    private static final int INCLUDE_FIRST = 0;
    private static final int NOT_INCLUDE_FIRST = 1;
    public int solution(int sticker[]) {
        int answer = 0;
        int size = sticker.length;
        if(size == 1){
            return sticker[0];
        }
        int[][] dp = new int[2][size];
        dp[INCLUDE_FIRST][0] = sticker[0];
        dp[INCLUDE_FIRST][1] = Math.max(sticker[0], sticker[1]);
        dp[NOT_INCLUDE_FIRST][1] = sticker[1];
        for(int i = 2 ; i < size ; i++){
            if(i != size-1){
                dp[INCLUDE_FIRST][i] = Math.max(dp[INCLUDE_FIRST][i-1], dp[INCLUDE_FIRST][i-2] + sticker[i]);
            }
            dp[NOT_INCLUDE_FIRST][i] = Math.max(dp[NOT_INCLUDE_FIRST][i-1], dp[NOT_INCLUDE_FIRST][i-2] + sticker[i]);
        }
        // System.out.println(Arrays.toString(dp[INCLUDE_FIRST]));
        // System.out.println(Arrays.toString(dp[NOT_INCLUDE_FIRST]));
        answer = Math.max(dp[INCLUDE_FIRST][size-2],dp[NOT_INCLUDE_FIRST][size-1]);
        return answer;
    }
}
