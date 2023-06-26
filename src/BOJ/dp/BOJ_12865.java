package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_12865 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[] weight = new int[n];
        int[] value = new int[n];
        int[][] dp = new int[n][k+1];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],NOT_VALID);
            st = new StringTokenizer(br.readLine());
            weight[i] = stoi.apply(st.nextToken());
            value[i] = stoi.apply(st.nextToken());
        }
        int result = cal(0,0,weight,value,k,n,dp);
        System.out.println(result);
    }
    private static final int NOT_VALID = -1;
    private static int cal(int depth, int nowWeight,int[] weight, int[] value,int k,int n, int[][]dp) {
        if(depth == n){
            return 0;
        }
        if(dp[depth][nowWeight] != NOT_VALID){
            return dp[depth][nowWeight];
        }
        int result = 0;
        if(nowWeight + weight[depth] <= k){
             result = Math.max(result, cal(depth+1,nowWeight+weight[depth],weight,value,k,n,dp)+value[depth]);
        }
        result = Math.max(result, cal(depth+1,nowWeight,weight,value,k,n,dp));
        dp[depth][nowWeight] = result;
        return result;
    }
}
