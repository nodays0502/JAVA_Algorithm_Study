package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_18353 {
    private static final int SIZE = 10_000_000;
    private static final int NOT_VALID = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] dp = new int[n];
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            dp[i] = 1;
            input[i] = stoi.apply(st.nextToken());
        }
        int result = 1;
        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = i-1 ; j >= 0 ; j--){
                if(input[i] < input[j] && dp[i] + 1 > dp[j]){
                    dp[j] = dp[i] + 1;
                    result = Math.max(result,dp[j]);
                }
            }
        }
        System.out.println(n-result);

    }

}
