package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_9657 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[]dp = new int[n+1];
        int result = cal(n,dp);
        if(result == 1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }

    private static int cal(int n, int[] dp) {
        if(dp[n] != 0){
            return dp[n];
        }
        if(n == 1 || n == 3 || n == 4){
            return 1;
        }
        int result = -1;
        if(n-1 > 0){
            result = Math.max(result,-cal(n-1,dp));
        }
        if(n-3 > 0){
            result = Math.max(result,-cal(n-3,dp));
        }
        if(n-4 > 0){
            result = Math.max(result,-cal(n-4,dp));
        }
        dp[n] = result;
        return result;
    }
}
