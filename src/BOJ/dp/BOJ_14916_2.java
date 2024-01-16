package BOJ.dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_14916_2 {
    private static final int[] MONEY = {5,2};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][change+1];
        for(int i = 0 ; i < 2; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        int result = cal(0,change,dp);
        if(result == INF){
            System.out.println(NOT_FOUND);
        }else{
            System.out.println(result);
        }
    }
    private static final int NOT_FOUND = -1;
    private static final int NOT_VALID = -1;
    private static final int INF = 100_000 / MONEY[0] + 100;
    private static int cal(int depth,int change,int[][] dp) {
        if(change == 0){
            return 0;
        }
        if(depth == 2){
            return INF;
        }
        if(dp[depth][change] != NOT_VALID){
            return dp[depth][change];
        }
        int result = INF;
        for(int i = change / MONEY[depth] ; i >= 0 ; i--){
            result = Math.min(result,cal(depth+1,change - i * MONEY[depth],dp)+i);
        }
        dp[depth][change] = result;
        return result;
    }


}

