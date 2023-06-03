package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_15993 {
    private static final int NOT_VALID = -1;
    private static final int LIMIT = 1_000_000_009;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int[][] dp = new int[100_000+1][2];
        for(int i = 0 ; i <= 100_000 ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        int test = stoi.apply(br.readLine());
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2; // 1+2 , 2+1
        dp[3][1] = 2; // 1+1+1 , 3
        for(int t = 0 ; t < test ; t++){
            int num = stoi.apply(br.readLine());
            int result1 = cal(num,1,dp);
            int result2 = cal(num,0,dp);
            System.out.println(result1+" "+result2);
        }
    }

    private static int cal(int num,int type ,int[][] dp) {
        if(num == 0){
            return 1;
        }
        int result = 0;
        if(dp[num][type] != NOT_VALID){
            return dp[num][type];
        }
        for(int i = 1; i <= 3 ; i++){
            if(num - i < 0){
                break;
            }
            result += cal(num-i,(type+1) % 2,dp);
            result %= LIMIT;
        }
        dp[num][type] = result;
        return result;
    }
}
