package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        int result = 0; // 아무것도 배치하지 않는 것
        result += cal(0, 0, n,dp);
        result += cal(0, 1, n,dp);
        result += cal(0, 2, n,dp);
        result %= LIMIT;
        System.out.println(result);
    }

    private static final int LIMIT = 9901;
    private static final int NOT_VALID = -1;
    private static int cal(int y, int x, int n,int[][]dp) { // 0 1 2 - OX XO XX
        if (y >= n-1) {
            return 1;
        }
        if(dp[y][x] != NOT_VALID){
            return dp[y][x];
        }
        int result = 0;
        for(int i = 0 ; i < 3 ; i++){
            if( (x == 0 && i == 0) || (x == 1 && i == 1)){
                continue;
            }
            result += cal(y+1,i,n,dp);
            result %= LIMIT;
        }

        dp[y][x] = result;
        return result;
    }
}
