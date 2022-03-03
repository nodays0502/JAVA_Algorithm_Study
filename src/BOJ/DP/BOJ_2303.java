package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_2303 {

    private static int dfs(int depth, boolean[] isVip, int n,int[] dp) {
        if (depth > n) {
            return 0;
        }
        if (depth == n) {
            return 1;
        }
        if(dp[depth] != 0){
            return dp[depth];
        }
        int result = 1;
        if (isVip[depth] || (depth +1 < n && isVip[depth + 1])) {
            result = dfs(depth + 1, isVip, n,dp);
        } else {
            result = dfs(depth + 1, isVip, n,dp) + dfs(depth + 2, isVip, n,dp);
        }
        dp[depth] = result;
        return result;
    }

    //    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Function<String,Integer> stoi = Integer::parseInt;
//        int n = stoi.apply(br.readLine());
//        int m = stoi.apply(br.readLine());
//        boolean[] isVip = new boolean[n];
//        for(int i = 0 ; i < m ; i++){
//            int num = stoi.apply(br.readLine()) - 1;
//            isVip[num] = true;
//        }
//        int[] dp = new int[n];
//        dp[0] = 1;
//        if(isVip[1] || isVip[0]){
//            dp[1] = 1;
//        }else{
//            dp[1] = 2;
//        }
//        for(int i = 2 ; i < n ; i++){
//            if(isVip[i] || isVip[i-1]){
//                dp[i] = dp[i-1];
//            }else{
//                dp[i] = dp[i-2] + dp[i-1];
//            }
//        }
//        System.out.println(dp[n-1]);
//    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int m = stoi.apply(br.readLine());
        boolean[] isVip = new boolean[n];
        for (int i = 0; i < m; i++) {
            int num = stoi.apply(br.readLine()) - 1;
            isVip[num] = true;
        }
        int[] dp = new int[n];
        System.out.println(dfs(0, isVip, n,dp));
    }

}