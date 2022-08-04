package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_5557 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        long[][] dp = new long[n][LIMIT+1];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        long result = dfs(1,input[0],input,n,dp);
        System.out.println(result);
    }

    private static final long NOT_VALID = -1;
    private static final int LIMIT = 20;
    private static long dfs(int depth, int sum, int[] input, int n, long[][] dp) {
        if(depth == n-1){
            if(sum == input[n-1]){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[depth][sum] != NOT_VALID){
            return dp[depth][sum];
        }
        long result = 0;
        if(sum + input[depth] >= 0 && sum + input[depth] <= LIMIT){
            result += dfs(depth+1,sum + input[depth],input,n,dp);
        }
        if(sum - input[depth] >= 0 && sum - input[depth] <= LIMIT){
            result += dfs(depth+1,sum - input[depth],input,n,dp);
        }
        dp[depth][sum] = result;
        return result;
    }
}
