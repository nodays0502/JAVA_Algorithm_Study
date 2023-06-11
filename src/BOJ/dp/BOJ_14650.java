package BOJ.dp;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_14650 {
    private static final int NOT_VALID = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[][] dp = new int[n][2*9+1];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        int result = cal(0,0,n,dp);
        System.out.println(result);
    }

    private static int cal(int depth, int sum, int n,int[][] dp) {
        if(depth == n){
            if(sum % 3 == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[depth][sum] != NOT_VALID) {
            return dp[depth][sum];
        }
        int result = 0;
        for(int i = 0 ; i < 3; i++){
            if(depth == 0 && i == 0){
                continue;
            }
            result += cal(depth+1,sum+i,n,dp);
        }
        dp[depth][sum] = result;
        return result;
    }
}
