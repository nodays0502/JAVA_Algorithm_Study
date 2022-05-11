package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_15989 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[][] dp = new int[10_000+1][4];
        for(int i = 0 ; i <= 10_000; i++){
            Arrays.fill(dp[i],-1);
        }
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;

        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 0;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int i = 0 ; i < n ; i++){
            int num = stoi.apply(br.readLine());
            int result = 0;
            for(int j = 1 ; j <= 3; j++){
                result += cal(dp,num,j);
            }
            System.out.println(result);
        }
    }

    private static int cal(int[][] dp, int num, int start) {
        if(dp[num][start] != -1){
            return dp[num][start];
        }
        dp[num][start] = 0;
        for(int i = 1 ; i <= start ; i++){
            dp[num][start] += cal(dp,num-start,i);
        }
        return dp[num][start];
    }
}
