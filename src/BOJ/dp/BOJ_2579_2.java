package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        int[][] dp = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],NOT_VALID);
            score[i] = Integer.parseInt(br.readLine());
        }
        int result = cal(n-1,score,1,n,dp);
        System.out.println(result);
    }
    private static final int NOT_VALID = -1;
    private static int cal(int depth, int[] score, int cnt,int n,int[][] dp) {
        if(depth < 0){
            return 0;
        }
        if(dp[depth][cnt]!= NOT_VALID){
            return dp[depth][cnt];
        }
        int result = 0;
        if(cnt < 2){
            result = Math.max(result,cal(depth-1,score,cnt+1,n,dp) + score[depth]);
        }
        result = Math.max(result,cal(depth-2,score,1,n,dp) + score[depth]);
        dp[depth][cnt] = result;
        return result;
    }
}
