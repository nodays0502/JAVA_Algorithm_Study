package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11727 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp,NOT_VALID);
        int result = cal(n,dp);
        System.out.println(result);
    }
    private static final int NOT_VALID = -1;
    private static final int LIMIT = 10007;
    private static int cal(int n, int[] dp) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 3;
        }
        if(dp[n] != NOT_VALID){
            return dp[n];
        }
        dp[n] = (cal(n-1,dp) + 2*cal(n-2,dp)) % LIMIT;
        return dp[n];
    }
}
