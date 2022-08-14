package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_1793 {
    private static final int SIZE = 250;
    private static final int NOT_VALID = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        long[] dp = new long[SIZE+1];
        while(true){
            String command = br.readLine();
            if(command == null){
                break;
            }
            int n = stoi.apply(command);
            long result = cal(n,dp);
            System.out.println(result);
        }
    }

    private static long cal(int n, long[] dp) {
        if(n == 0){
            return 1;
        }
        if(dp[n] != NOT_VALID){
            return dp[n];
        }
        long result = 0;
        if(n-1 >= 0){
            result += cal(n-1,dp);
        }
        if(n-2 >= 0){
            result += 2 * cal(n-2,dp);
        }
        dp[n] = result;
        return result;
    }


}
