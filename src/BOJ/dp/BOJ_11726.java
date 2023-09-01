package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11726 {
    private static final int NOT_VALID = -1;
    private static final int LIMIT = 10_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        Arrays.fill(dp,NOT_VALID);
        dp[1] = 1;
        dp[2] = 2;
        int result = cal(n,dp);
        System.out.println(result);
    }

    private static int cal(int n, int[]dp) {
        if(dp[n] != NOT_VALID){
            return dp[n];
        }
        return dp[n] = (cal(n-1,dp) + cal(n-2,dp))% LIMIT;
    }
}
