package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15624 {
    private  static final int LIMIT = 1_000_000_007;
    private  static final int NOT_VALID = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int result = cal(n,dp);
        System.out.println(result);
    }

    private static int cal(int n, int[] dp) {
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        if(dp[n] != NOT_VALID){
            return dp[n];
        }
        return dp[n] = (cal(n-1,dp) + cal(n-2,dp)) % LIMIT;
    }
}
