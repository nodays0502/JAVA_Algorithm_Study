package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15992 {
    private static final int LIMIT = 1_000_000_009;
    private static final int[] NUMBER = {3,2,1};
    private static final int NOT_VALID = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int testCnt = stoi.apply(st.nextToken());
        int[][] dp = new int[1_000+1][1_000+1];
        for(int i = 0 ; i <= 1_000 ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        for(int i = 0 ; i < testCnt ; i++){
            st = new StringTokenizer(br.readLine());
            int n = stoi.apply(st.nextToken());
            int m = stoi.apply(st.nextToken());
            System.out.println(cal(m,n,dp));
        }
    }

    private static int cal(int depth, int n, int[][] dp) {
        if(n == 0 && depth == 0){
            return 1;
        }
        if(depth == 0){
            return 0;
        }
        if(dp[depth][n] != NOT_VALID){
            return dp[depth][n];
        }
        int result = 0;
        for(int i = 0 ; i < NUMBER.length ; i++){
            if(n - NUMBER[i] >= 0){
                result += cal(depth-1,n - NUMBER[i],dp);
                result %= LIMIT;
            }
        }
        dp[depth][n] = result;
        return result;
    }
}
