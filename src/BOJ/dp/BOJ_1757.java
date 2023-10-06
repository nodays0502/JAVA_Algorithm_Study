package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1757 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] distance = new int[n];
        for(int i = 0 ; i < n ; i++){
            distance[i] = stoi.apply(br.readLine());
        }
        int[][]dp = new int[n+1][m+1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        int result = cal(0,distance,0,m,n,dp);
        System.out.println(result);
    }
    private static final int INF = 1987654321;
    private static final int NOT_VALID = -1;
    private static int cal(int depth,int[] distance, int fatigue, int m,int n,int[][] dp) {
        if(depth >= n && fatigue == 0){
            return 0;
        }
        if(depth >= n){
            return -INF;
        }
        if(dp[depth][fatigue] != NOT_VALID){
            return dp[depth][fatigue];
        }
        int result = 0;
        if(fatigue < m){
            result = Math.max(result,cal(depth+1,distance,fatigue+1,m,n,dp) + distance[depth]);
        }
        if(fatigue != 0 && depth + fatigue <= n-1){
            System.out.println(depth+fatigue+" "+fatigue );
            result = Math.max(result,cal(depth + fatigue,distance,0,m,n,dp));
        }
        if(fatigue == 0){
            result = Math.max(result,cal(depth + 1,distance,0,m,n,dp));
        }
        dp[depth][fatigue] = result;
        return result;
    }
}
