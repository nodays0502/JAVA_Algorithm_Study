package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16195 {
    private static final int LIMIT = 1_000_000_009;
    private static final int NOT_VALID = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCnt = stoi.apply(st.nextToken());
        int[][] dp = new int[1_000+1][1_000+1];
        for(int i = 0 ; i <= 1_000 ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        for(int t = 0 ; t < testCnt ; t++){
            st = new StringTokenizer(br.readLine());
            int n = stoi.apply(st.nextToken());
            int m = stoi.apply(st.nextToken());
            int result = cal(n,m,dp);
            System.out.println(result);
        }
    }

    private static int cal(int n, int depth,int[][] dp) {
        if(n == 0){
            return 1;
        }
        if(depth <= 0){
            return 0;
        }
        if(dp[n][depth] != NOT_VALID){
            return dp[n][depth];
        }
        int result = 0;
        for(int i = 1 ; i <= 3 ; i++){
            if(n-i >= 0){
                result += cal(n-i,depth-1,dp);
                result %= LIMIT;
            }
        }
        dp[n][depth] = result;
        return result;
    }
}
