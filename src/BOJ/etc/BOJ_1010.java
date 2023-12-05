package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
    private static final int MAX_SIZE = 30;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        int[][] dp = new int[MAX_SIZE+1][MAX_SIZE+1];
        for(int t = 0 ; t < testCnt ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int result = comb(m,n,dp);
            System.out.println(result);
        }
    }
    private static final int NOT_VALID = 0;
    private static int comb(int m, int n,int[][]dp) {
        if(n == m || n == 0){
            return 1;
        }
        if(dp[n][m] != NOT_VALID){
            return dp[n][m];
        }
        dp[n][m] = comb(m-1,n,dp) + comb(m-1,n-1,dp);
        return dp[n][m];
    }
}
