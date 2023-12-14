package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_11048 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <  m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = NOT_VALID;
            }
        }
        int result = cal(0,0,map,n,m,dp);
        System.out.println(result);
    }
    private static final int[] DY = {1,0,1};
    private static final int[] DX = {0,1,1};
    private static final int NOT_VALID = -1;
    private static int cal(int y, int x, int[][] map , int n , int m,int[][] dp){
        if(y == n-1 && x == m-1){
            return map[y][x];
        }
        if(dp[y][x] != NOT_VALID){
            return dp[y][x];
        }
        int result = 0;
        for(int i = 0 ; i < 3 ; i++){
            int ny = y + DY[i];
            int nx = x + DX[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m){
                continue;
            }
            result = Math.max(result,cal(ny,nx,map,n,m,dp)+map[y][x]);
        }
        dp[y][x] = result;
        return result;
    }
}
