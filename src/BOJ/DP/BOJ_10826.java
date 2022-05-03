package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10826 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        BigInteger[] dp = new BigInteger[n+1];
        System.out.println(fib(n,dp));
    }
    private static BigInteger fib(int now,BigInteger[] dp){
        if(now == 0){
            return new BigInteger("0");
        }
        if(now == 1){
            return new BigInteger("1");
        }
        if(dp[now] != null){
            return dp[now];
        }
        return dp[now] = fib(now-1,dp).add(fib(now-2,dp));
    }
}
