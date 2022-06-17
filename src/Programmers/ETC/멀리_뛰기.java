package Programmers.ETC;

import java.util.Arrays;

public class 멀리_뛰기 {
    private static final int LIMIT = 1234567;
    private static final long NOT_VALID = -1L;
    public long solution(int n) {
        long[] dp = new long[n+1];
        Arrays.fill(dp,NOT_VALID);
        long answer = dfs(0,n,dp) ;
        return answer;
    }
    private long dfs(int position, int n,long[] dp){
        if(position == n){
            return 1;
        }
        if(dp[position] != NOT_VALID){
            return dp[position];
        }
        long result = 0;
        for(int i = 1 ; i <= 2 ; i++){
            if(position + i <= n){
                result += dfs(position + i,n,dp);
                result %= LIMIT;
            }
        }
        dp[position] = result;
        return result;
    }
}
