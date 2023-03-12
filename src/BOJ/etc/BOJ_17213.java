package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_17213 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int m = stoi.apply(br.readLine());
        int[][] dp = new int[n+1][m+1];
        int result = cal(n,m,dp);
        System.out.println(result);
    }

    private static int cal(int depth, int num,int[][] dp) {
        if(depth == 0 && num == 0){
            return 1;
        }
        if(depth == 0 || num == 0){
            return 0;
        }
        if(dp[depth][num] != 0){
            return dp[depth][num];
        }
        int result = 0;
        for(int i = 1 ; i <= num ; i++){
            result += cal(depth-1,num-i,dp);
        }
        dp[depth][num] = result;
        return result;
    }
}
