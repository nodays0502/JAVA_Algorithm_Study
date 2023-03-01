package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_20162 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(br.readLine());
        }
        int result = cal(input,n);
        System.out.println(result);
    }

    private static int cal(int[] input, int n) {
        int[] dp = Arrays.copyOf(input,n);
        int result= 0;
        for(int i = 0 ; i < n ; i++){
            result = Math.max(result,input[i]);
            for(int j = i+1 ; j < n ; j++){
                if(input[i] < input[j] && dp[i] + input[j] > dp[j]){
                    dp[j] = dp[i] + input[j];
                    result = Math.max(result,dp[j]);
                }
            }
        }
        return result;
    }
}
