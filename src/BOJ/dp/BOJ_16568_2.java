package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16568_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int a = stoi.apply(st.nextToken());
        int b = stoi.apply(st.nextToken());
        int[] dp = new int[n+1];
        for(int i = 1; i <= n ; i++){
            dp[i] = dp[i-1] +1;
            if(i-a-1 >= 0 ){
                dp[i] = Math.min(dp[i],dp[i-a-1]+1);
            }
            if(i-b-1 >= 0 ){
                dp[i] = Math.min(dp[i],dp[i-b-1]+1);
            }
        }
        System.out.println(dp[n]);
    }
}
