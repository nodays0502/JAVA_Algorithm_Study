package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14430 {
    private static final int NOT_VALID = -1;
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                dp[i][j] = NOT_VALID;
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = cal(0,0,map,n,m,dp);
        System.out.println(result);
    }
    private static final int[] DY = {1,0};
    private static final int[] DX = {0,1};
    private static int cal(int y, int x, int[][] map, int n, int m,int[][] dp) {
        if(dp[y][x] != NOT_VALID){
            return dp[y][x];
        }
        int result = 0;
        for(int i = 0 ; i < 2; i++){
            int ny = y + DY[i];
            int nx = x + DX[i];
            if(ny >= n || nx >= m){
                continue;
            }
            result = Math.max(result,cal(ny,nx,map,n,m,dp));
        }
        if(map[y][x] == 1){
            result++;
        }
        dp[y][x] = result;
        return result;
    }
}
