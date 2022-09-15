package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_11058 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        long[] dp = new long[n+1];
        Arrays.fill(dp,NOT_VALID);
        long result = cal(n,dp);
        System.out.println(result);
    }
    private static final long NOT_VALID = -1;
    private static long cal(int n,long[] dp) {
        if(n == 1 || n == 0){
            return n;
        }
        if(dp[n] != NOT_VALID){
            return dp[n];
        }
        long result = 0;
        result = Math.max(result,cal(n-1,dp) + 1);
        for(int i = 1 ; i < n ; i++){
            if(n-i-2 < 0){
                break;
            }
            result = Math.max(result,(i+1) * cal(n-i-2,dp));
        }
        dp[n] = result;
        return result;
    }
}
