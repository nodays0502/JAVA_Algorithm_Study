package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2096 {

    private static final int NOT_VALID = -1;
    private static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n+1][3];
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = stoi.apply(st.nextToken());
            map[i][1] = stoi.apply(st.nextToken());
            map[i][2] = stoi.apply(st.nextToken());
        }
        int[][] dp = new int[n+1][3];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        int max = calMax(0,1,map,dp,n);
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        int min = calMin(0,1,map,dp,n);
        System.out.println(max+" "+min);
    }

    private static int calMin(int depth, int position, int[][] map, int[][] dp, int n) {
        if(depth > n){
            return 0;
        }
        if(dp[depth][position] != NOT_VALID){
            return dp[depth][position];
        }
        int result = INF;
        for(int i = -1 ; i <= 1; i++){
            int next = position + i;
            if(next < 0 || next >= 3){
                continue;
            }
            result = Math.min(result,calMin(depth+1,next,map,dp,n));
        }
        result += map[depth][position];
        dp[depth][position] = result;
        return result;
    }
    private static int calMax(int depth, int position, int[][] map,int[][] dp ,int n) {
        if(depth > n){
            return 0;
        }
        if(dp[depth][position] != NOT_VALID){
            return dp[depth][position];
        }
        int result = 0;
        for(int i = -1 ; i <= 1; i++){
            int next = position + i;
            if(next < 0 || next >= 3){
                continue;
            }
            result = Math.max(result,calMax(depth+1,next,map,dp,n));
        }
        result += map[depth][position];
        dp[depth][position] = result;
        return result;
    }
}
