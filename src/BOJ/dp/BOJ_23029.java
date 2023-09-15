package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_23029 {
    private static final int NOT_VALID = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] input = new int[n];
        int[][] dp = new int[n][3];
        for(int i = 0 ; i < n;  i++){
            Arrays.fill(dp[i],NOT_VALID);
            input[i] = stoi.apply(br.readLine());
        }
        int result = cal(0,0,input,n,dp);
        System.out.println(result);
    }

    private static int cal(int depth, int cnt, int[] input,int n,int[][] dp) {
        if(depth >= n){
            return 0;
        }
        if(dp[depth][cnt] != NOT_VALID){
            return dp[depth][cnt];
        }
        int result = 0;
        if(cnt < 2){
            result = Math.max(result,cal(depth+1,cnt+1,input,n,dp) + input[depth] / (cnt+1));
        }
        result = Math.max(result,cal(depth+1,0,input,n,dp));
        dp[depth][cnt] = result;
        return result;
    }
}
