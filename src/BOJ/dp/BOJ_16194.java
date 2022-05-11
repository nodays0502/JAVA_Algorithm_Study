package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16194 {
    private static final int INF = 987_654_321;
    private static int dfs(int depth, int[] input,int[] dp){
        if(depth < 0){
            return INF;
        }
        if(depth == 0){
            return 0;
        }
        if(dp[depth] != 0){
            return dp[depth];
        }
        int result = INF;
        for(int i = depth ; i > 0 ; i--){
            int share = depth / i;
            for(int j = 1; j <= share ; j++){
                result = Math.min(result, dfs(depth - i * j,input,dp) + j * input[i]);
            }
        }
        dp[depth] = result;
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n+1];
        int[] dp = new int[n+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1 ; i <= n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        System.out.println(dfs(n,input,dp));
    }
}
