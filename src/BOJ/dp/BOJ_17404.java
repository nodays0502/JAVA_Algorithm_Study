package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17404 {

    private static final int INF = 987654321;
    private static final int NOT_VALID = -1;
    private static final int SIZE = 3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] input = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < SIZE ; j++){
                input[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = INF;
        int[][] dp = new int[n][SIZE];
        for(int i = 0 ; i < SIZE ; i++){
            init(dp,n);
            result = Math.min(result, dfs(0,i,input,n,i,dp) + input[n-1][i]);
        }
        System.out.println(result);
    }

    private static void init(int[][] dp, int n) {
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
    }

    private static int dfs(int depth, int prev,int[][] input, int n,int ban,int[][] dp) {
        if(depth == n-1){
            return 0;
        }
        if(dp[depth][prev] != NOT_VALID){
            return dp[depth][prev];
        }
        int result = INF;
        for(int i = 0 ; i < SIZE ; i++){
            if(prev == i){
                continue;
            }
            if(depth == n-2 && i == ban){
                continue;
            }
            result = Math.min(result, dfs(depth+1,i,input,n,ban,dp) + input[depth][i]);
        }
        dp[depth][prev] = result;
        return result;
    }
}
