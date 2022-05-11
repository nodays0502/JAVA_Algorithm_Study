package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14728 {
    private static int dfs(int time, int depth, int n, int[]needTime, int[]score, int[][]dp){
        if(depth == n){
            return 0;
        }
        if(dp[time][depth] != -1){
            return dp[time][depth];
        }
        int result = 0;
        if(time >= needTime[depth]){
            result = Math.max(result, dfs(time - needTime[depth],depth + 1,n,needTime,score,dp) + score[depth]);
        }
        result = Math.max(result, dfs(time,depth + 1,n,needTime,score,dp));
        dp[time][depth] = result;
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] needTime = new int[n];
        int[] score = new int[n];
        for(int i = 0 ; i < n;  i++){
            st = new StringTokenizer(br.readLine()," ");
            needTime[i] = stoi.apply(st.nextToken());
            score[i] = stoi.apply(st.nextToken());
        }
        int[][] dp = new int[m+1][n];
        for(int i = 0 ; i <= m ; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(dfs(m,0,n,needTime,score,dp));
    }
}
