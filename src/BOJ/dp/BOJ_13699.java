package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_13699 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];
        dp[0] = 1;
        long result = cal(n,dp);
        System.out.println(result);
    }
    private static final long NOT_VALID = 0;
    private static long cal(int n, long[] dp) {
        if(dp[n] != NOT_VALID){
            return dp[n];
        }
        long temp = 0;
        for(int i = 0 ; i < n ; i++){
            temp += cal(i,dp) * cal(n-i-1,dp);
        }
        return dp[n] = temp;
    }
}
