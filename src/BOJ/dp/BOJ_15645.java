package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15645 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][3];
        int[][] minDP = new int[n][3];
        int[][] maxDP = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j++){
                minDP[i][j] = NOT_VALID;
                maxDP[i][j] = NOT_VALID;
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int min = INF;
        int max = 0;
        for(int i = 0 ; i < 3 ; i++){
            min = Math.min(min,findMin(0,i,map,n,minDP));
            max = Math.max(max,findMax(0,i,map,n,maxDP));
        }
        System.out.println(max + " " + min);
    }

    private static final int NOT_VALID = -1;
    private static final int INF = 987654321;

    private static int findMin(int y,int x, int[][] map, int n,int[][]dp) {
        if(y >= n){
            return 0;
        }
        if(dp[y][x] != NOT_VALID){
            return dp[y][x];
        }
        int result = INF;
        for(int i = -1 ; i <= 1 ; i++){
            int nx = x + i;
            if(nx >= 0 && nx < 3){
                result = Math.min(result,findMin(y+1,nx,map,n,dp));
            }
        }
        result += map[y][x];
        dp[y][x] = result;
        return result;
    }

    private static int findMax(int y,int x, int[][] map, int n,int[][] dp) {
        if(y >= n){
            return 0;
        }
        if(dp[y][x] != NOT_VALID){
            return dp[y][x];
        }
        int result = 0;
        for(int i = -1 ; i <= 1 ; i++){
            int nx = x + i;
            if(nx >= 0 && nx < 3){
                result = Math.max(result,findMax(y+1,nx,map,n,dp));
            }
        }
        result += map[y][x];
        dp[y][x] = result ;
        return result;
    }
}
