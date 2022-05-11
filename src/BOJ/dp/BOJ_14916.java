package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_14916 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] dp = new int[n+1];
        int result = dfs(0,n,dp);
        if(result == INF){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
    private static int[] money = {5,2};
    private static final int INF = 987654321;
    private static int dfs(int depth, int n, int[] dp) {
        if(dp[n] != 0){
            return dp[n];
        }
        if(depth == 2 && n != 0){
            return INF;
        }
        if(n == 0){
            return 0;
        }
        int result = INF;
        for(int i = n / money[depth] ; i >= 0 ; i--){
            result = Math.min(result,dfs(depth+1,n - money[depth] * i,dp) + i);
            if(result != INF){
                break;
            }
        }
        dp[n] = result;
        return result;
    }
}
