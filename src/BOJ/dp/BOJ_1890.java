package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        long[][] dp = new long[n][n];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int length = map[i][j];
                if(length == 0){
                    continue;
                }
                if(i + length < n){
                    dp[i + length][j] += dp[i][j];
                }
                if(j + length < n ){
                    dp[i][j+length] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }



    private static final int[] DY = {1,0};
    private static final int[] DX = {0,1};
    private static final long INF = Long.MAX_VALUE;
    private static final int NOT_VALID = -1;
    private static long cal(int y, int x, int[][] map, int n,long[][] dp) {
        if(y == n-1 && x == n-1){
            return 1;
        }
        if(dp[y][x] != NOT_VALID){
            return dp[y][x];
        }
        long result = 0;
        for(int i = 0 ; i < 2; i++){
            int ny = y + map[y][x] * DY[i];
            int nx = x + map[y][x] * DX[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= n){
                continue;
            }
            result += cal(ny,nx,map,n,dp);
        }
        dp[y][x] = result;
        return result;
    }
}
