package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_17626 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] dp = new int[n+1];
        int result = cal(n,dp);
        System.out.println(result);
    }
    private static final int INF = 987654321;
    private static final int NOT_VALID = 0;
    private static int cal(int n, int[] dp) {
        if(dp[n] != NOT_VALID){
            return dp[n];
        }
        int result = INF;
        for(int i = (int)Math.sqrt(n) ; i >= 1 ; i--){
            if(n == i * i){
                return 1;
            }else{
                result = Math.min(result,cal(n - i*i, dp)+1);
            }
        }
        dp[n] = result;
        return result;
    }

}
