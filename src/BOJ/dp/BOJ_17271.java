package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17271 {
    private static final int LIMIT = 1_000_000_007;
    private static final int NOT_VALID = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] dp = new int[n+1];
        Arrays.fill(dp,NOT_VALID);
        int result = cal(n,m,dp);
        System.out.println(result);
    }

    private static int cal(int n, int m, int[] dp) {
        if(dp[n] != NOT_VALID){
            return dp[n];
        }
        if(n == 0){
            return 1;
        }
        int result = 0;
        if(n - m >= 0 ){
            result += cal(n-m,m,dp);
            result %= LIMIT;
        }
        result += cal(n-1,m,dp);
        result %= LIMIT;
        dp[n] = result;
        return result;
    }
}
