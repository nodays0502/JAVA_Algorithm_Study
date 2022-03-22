package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14501 {
    private static int dfs(int depth , int n , int[] time , int[] price, int[] dp){
        if(depth == n){
            return 0;
        }
        if(dp[depth] != 0){
            return dp[depth];
        }
        int result = 0;
        result = Math.max(result, dfs(depth+1,n,time,price,dp));
        if(depth + time[depth]  <= n){
            result = Math.max(result, dfs(depth + time[depth],n,time,price,dp) + price[depth]);
        }
        dp[depth] = result;
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] time = new int[n];
        int[] price = new int[n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            time[i] = stoi.apply(st.nextToken());
            price[i] = stoi.apply(st.nextToken());
        }
        int[] dp = new int[n];
        System.out.println(dfs(0 , n , time , price, dp));
    }
}
