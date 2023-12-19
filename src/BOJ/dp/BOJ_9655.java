package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9655 {
    private static final int WIN = 1;
    private static final int LOSE = -1;
    private static final int NOT_VALID = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int result = cal(n,dp);
        if(result == WIN){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
    private static int cal(int depth,int[] dp){
        if(depth == 1){
            return WIN;
        }
        if(dp[depth] != NOT_VALID){
            return dp[depth];
        }
        int result = LOSE;
        result = Math.max(result,-cal(depth-1,dp));
        if(depth > 3){
            result = Math.max(result,-cal(depth-3,dp));
        }
        dp[depth] = result;
        return result;
    }
}
