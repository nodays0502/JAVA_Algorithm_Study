package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15486 {
    private static class Work{
        int day;
        int pay;

        public Work(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        Work input[] = new Work[n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int day = stoi.apply(st.nextToken());
            int pay = stoi.apply(st.nextToken());
            input[i] = new Work(day,pay);
        }
        int dp[] = new int[n+1];
//        int max = 0;
//        for(int i = 0 ; i < n ; i++){
//            Work work = input[i];
//            max = Math.max(max,dp[i]);
//            dp[i] = max;
//            if(work.day + i  <= n){
//                dp[work.day + i] = Math.max(dp[work.day + i], max + work.pay);
//            }
//            System.out.println(Arrays.toString(dp));
//        }
        Arrays.fill(dp,-1);
        System.out.println(dfs(n,input,0,dp));
//        int result = Math.max(dp[n-1],dp[n]);
//        System.out.println(result);
    }

    private static int dfs(int n, Work[] input ,int now, int[] dp) {
        if(now >= n){
            return 0;
        }
        if(dp[now] != -1){
            return dp[now];
        }
//        System.out.println(now);
        Work work = input[now];
        int result = 0;
        int next = work.day + now;
        if(next <= n){
            result = Math.max(dfs(n,input,next,dp) + work.pay,dfs(n,input,now + 1,dp));
        }else{
            result = dfs(n,input,now + 1,dp);
        }
        dp[now] = result;
        return result;
    }
}
