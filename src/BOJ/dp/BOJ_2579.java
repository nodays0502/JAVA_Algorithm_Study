package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_2579 {

    private static final int NOT_VALID = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] input = new int[n+1];
        int[][] dp = new int[n+1][3];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i],NOT_VALID);
            if(i == 0){
                continue;
            }
            input[i] = stoi.apply(br.readLine());
        }
        int result = cal(n,1,input,n,dp);
        System.out.println(result);
    }

    private static int cal(int depth, int cnt, int[] input, int n,int[][]dp ) {
        if(dp[depth][cnt] != NOT_VALID){
            return dp[depth][cnt];
        }
        int result = 0;
        if(cnt + 1 < 3 && depth -1 > 0){
            result = Math.max(result,cal(depth-1,cnt+1,input,n,dp));
        }
        if(depth -2 > 0){
            result = Math.max(result,cal(depth-2,1,input,n,dp));
        }
        result += input[depth];
        dp[depth][cnt] = result;
        return result;
    }
}
