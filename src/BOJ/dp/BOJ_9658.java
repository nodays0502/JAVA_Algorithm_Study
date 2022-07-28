package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_9658 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] dp = new int[n+1];
        if(cal(n,dp) == WIN){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
        System.out.println(Arrays.toString(dp));
    }
    private static final int NOT_VALID = 0;
    private static final int WIN = 1;
    private static final int LOSE = -1;
    private static int cal(int n, int[] dp) {
        if(n == 1){
            return LOSE; // SK가 지는 것
        }
        if(dp[n] != NOT_VALID){
            return dp[n];
        }
        int result = LOSE;
        for(int i = 1 ; i <= 4 ; i++){
            if(i == 2){
                continue;
            }
            if(n - i <= 0){
                break;
            }
            result = Math.max(result,-cal(n-i,dp) );
        }
        dp[n] = result;
        return result;
    }
}
