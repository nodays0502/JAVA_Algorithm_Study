package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16568 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int a = stoi.apply(st.nextToken());
        int b = stoi.apply(st.nextToken());
        int[] dp = new int[n+1];
        Arrays.fill(dp,NOT_VALID);
        int result = cal(n,dp,a,b);
        System.out.println(result);
    }
    private static final int NOT_VALID = -1;
    private static final int INF = 987654321;
    private static int cal(int n, int[] dp,int a, int b) {
        if(n == 0){
            return 0;
        }
        if(dp[n] != NOT_VALID){
            return dp[n];
        }
        int result = INF;
        if(n-1-b >= 0){
            result = Math.min(result,cal(n-1-b,dp,a,b) + 1);
        }
        if(n-1-a >= 0){
            result = Math.min(result,cal(n-1-a,dp,a,b) + 1);
        }
        result = Math.min(result,cal(n-1,dp,a,b) + 1);
        dp[n] = result;
        return result;
    }
}
