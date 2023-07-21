package Programmers.ETC;

public class _2xn타일링 {
    private static final int LIMIT = 1_000_000_007;
    private static final int NOT_VALID = 0;
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n +1];
        answer = dfs(n,dp);
        return answer;
    }
    private int dfs(int depth, int[] dp){
        if(dp[depth] != NOT_VALID){
            return dp[depth];
        }
        if(depth == 1){
            return 1;
        }
        if(depth == 2){
            return 2;
        }
        return dp[depth] = (dfs(depth-1,dp) + dfs(depth-2,dp)) % LIMIT;
    }
}
