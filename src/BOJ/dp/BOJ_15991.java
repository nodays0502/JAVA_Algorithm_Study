package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15991 {
    private static final int[] MONEY = {1,2,3};
    private static final int LIMIT = 1_000_000_009;
    private static final int NOT_VALID = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] dp = new int[100_000+1];
        Arrays.fill(dp,NOT_VALID);
        dp[0] = 1;
        for(int i = 0 ; i < n ; i++){
            int num = stoi.apply(br.readLine());
            int result = cal(num,dp);
            System.out.println(result);
        }
    }

    private static int cal(int num, int[] dp) {
        if(dp[num] != NOT_VALID){
            return dp[num];
        }
        int result = 0;
        for(int i = 0 ; i < 3; i++){
            if(num == MONEY[i]){
                result++;
            }
        }
        for(int i = 0 ; i < 3 ; i++){
            if(num >= 2*MONEY[i]){
                result += cal(num - 2*MONEY[i],dp);
                result %= LIMIT;
            }
        }
        dp[num] = result;
        return result;
    }
}
