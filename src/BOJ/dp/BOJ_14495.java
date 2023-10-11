package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14495 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];

        long result = cal(n,dp);
        System.out.println(result);
    }
    private static final int NOT_VALID = 0;
    private static long cal(int n,long[] dp) {
        if(n == 1 || n == 2 || n == 3){
            return 1;
        }
        if(dp[n] != NOT_VALID){
            return dp[n];
        }
        return dp[n] = cal(n-1,dp) + cal(n-3,dp);
    }
}
