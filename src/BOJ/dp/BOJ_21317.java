package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21317 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] smallJump = new int[n];
        int[] bigJump = new int[n];
        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            smallJump[i] = stoi.apply(st.nextToken());
            bigJump[i] = stoi.apply(st.nextToken());
        }
        int k = stoi.apply(br.readLine());
        int[][] dp = new int[n][2];
        int result = cal(1,NOT_USED,smallJump,bigJump,n,k,dp);
        System.out.println(result);
    }

    private static final int INF = 987_654_321;
    private static final int NOT_USED = 0;
    private static final int USED = 1;
    private static final int NOT_VALID = 0;

    private static int cal(int now, int used,int[] smallJump, int[] bigJump, int n, int k,int[][]dp) {
        int result = INF;
        if(now == n){
            return 0;
        }
        if(dp[now][used] != NOT_VALID){
            return dp[now][used];
        }
        if(now + 1 <= n){
            result = Math.min(result,cal(now+1,used,smallJump,bigJump,n,k,dp) + smallJump[now]);
        }
        if(now + 2 <= n){
            result = Math.min(result,cal(now+2,used,smallJump,bigJump,n,k,dp) + bigJump[now]);
        }
        if(used == NOT_USED && now + 3 <= n){
            result = Math.min(result,cal(now+3,USED,smallJump,bigJump,n,k,dp) + k);
        }
        dp[now][used] = result;
        return result;
    }
}
