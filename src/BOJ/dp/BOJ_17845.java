package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17845 {
    private static final int NOT_VALID = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[] importance = new int[k];
        int[] time = new int[k];
        int[][] dp = new int[k][n+1];
        for(int i = 0 ; i < k ; i++){
            Arrays.fill(dp[i],NOT_VALID);
            st = new StringTokenizer(br.readLine());
            importance[i] = stoi.apply(st.nextToken());
            time[i] = stoi.apply(st.nextToken());
        }
        int result = cal(0,importance,time,n,k,dp);
        System.out.println(result);
    }

    private static int cal(int depth, int[] importance, int[] time, int n, int k,int[][]dp) {
        if(depth == k){
            return 0;
        }
        if(dp[depth][n] != NOT_VALID){
            return dp[depth][n];
        }
        int result = 0;
        if(time[depth] <= n){
            result = Math.max(result,cal(depth+1,importance,time,n-time[depth],k,dp) + importance[depth]);
        }
        result = Math.max(result,cal(depth+1,importance,time,n,k,dp));
        dp[depth][n] = result;
        return result;
    }
}
