package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2688 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(br.readLine());
        long[][] dp = new long[64 + 1][10 + 1];
        for(int i = 0 ; i < 10 ; i++){
           dp[1][i] = 1;
        }
        dp[1][TOTAL_SUM_INDEX] = 10;
        for(int t = 0 ; t < test ; t++){
            int num = stoi.apply(br.readLine());
            System.out.println(cal(num,dp));
        }
    }

    private static final long NOT_VALID = 0;
    private static final int TOTAL_SUM_INDEX = 10;

    private static long cal(int num, long[][] dp) {
        if(dp[num][TOTAL_SUM_INDEX] != NOT_VALID){
            return dp[num][TOTAL_SUM_INDEX];
        }
        if(dp[num-1][TOTAL_SUM_INDEX] == NOT_VALID){
            cal(num-1,dp);
        }
        for(int i = 0 ; i < 10 ; i++){
            for(int j = i ; j < 10 ; j++){
                dp[num][i] += dp[num-1][j];
                dp[num][TOTAL_SUM_INDEX] += dp[num-1][j];
            }
        }
        return dp[num][TOTAL_SUM_INDEX];
    }
}
