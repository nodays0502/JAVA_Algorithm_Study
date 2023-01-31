package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_17291 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] dp = new int[n+1];
        dp[1] = 1;
        cal(n,dp);
//        System.out.println(Arrays.toString(dp));
        int result = 0;
        int length = 3;
        if(n % 2 == 0){
            length = 2;
        }
        for(int i = n ; i >= Math.max(0,n - length) ; i--){
            result += dp[i];
        }
        System.out.println(result);
    }
    private static int cal(int num, int[] dp){
        if(num <= 0){
            return 0;
        }
        if(dp[num] != 0){
            return dp[num];
        }
        int length = 3;
        if(num % 2 == 0){
            length = 4;
        }
        int result = 0;
        for(int i = 1 ; i <= length ; i++){
            result += cal(num - i,dp);
        }
        dp[num] = result;
        return result;
    }
}
