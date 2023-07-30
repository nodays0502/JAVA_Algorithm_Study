package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1010 {
    private static final int MAX_VALUE = 30;
    private static final int NOT_VALID = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCnt = stoi.apply(st.nextToken());
        int[][] dp = new int[MAX_VALUE+1][MAX_VALUE+1];
        for(int t = 0 ; t < testCnt ; t++){
            st = new StringTokenizer(br.readLine());
            int n = stoi.apply(st.nextToken());
            int m = stoi.apply(st.nextToken());
            int result = comb(m,n,dp);
            System.out.println(result);
        }
    }
    private static final int comb(int n , int r,int[][] dp){
        if(dp[n][r] != NOT_VALID){
            return dp[n][r];
        }
        if(r == 0 || r == n){
            return 1;
        }
        return dp[n][r] = comb(n-1,r,dp) + comb(n-1,r-1,dp);
    }
}
