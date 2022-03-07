package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_2747 {
    private static int fib(int num,int[] dp){
        if(num == 1 || num == 2){
            return 1;
        }
        if(dp[num] != 0){
            return dp[num];
        }
        return dp[num] = fib(num-1,dp) + fib(num-2,dp);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] dp = new int[n+1];
        System.out.println(fib(n,dp));
    }
}
