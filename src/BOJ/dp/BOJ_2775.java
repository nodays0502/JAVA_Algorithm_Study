package BOJ.dp;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2775 {
    private static final int SIZE = 14;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int testCnt = stoi.apply(br.readLine());
        int[][] dp = new int[SIZE+1][SIZE+1];
        for(int t = 0 ; t < testCnt ; t++){
            int k = stoi.apply(br.readLine());
            int n = stoi.apply(br.readLine());
            System.out.println(cal(k,n,dp));
        }
    }

    private static final int NOT_VALID = 0;
    private static int cal(int k, int n,int[][] dp) {
        if(dp[k][n] != NOT_VALID){
            return dp[k][n];
        }
        if(k == 0){
            return n;
        }
        int result = 0;
        for(int i = 1 ; i <= n ; i++ ){
            result += cal(k-1,i,dp);
        }
        return dp[k][n] = result;
    }
}
