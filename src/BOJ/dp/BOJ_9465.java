package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < testCnt ; t++){
            int m = Integer.parseInt(br.readLine());
            int[][] map = new int[2][m];
            int[][] dp = new int[2][m];
            for(int i = 0 ; i < 2 ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < m ; j++){
                    dp[i][j] = NOT_VALID;
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = Math.max(cal(1,0,map,2,m,dp),cal(0,0,map,2,m,dp));
            System.out.println(result);
        }
    }
    private static final int[] DY = {-1,0,1};
    private static final int[] DX = {0,1,0};
    private static final int NOT_VALID = -1;
    private static int cal(int y, int x, int[][] map, int n, int m,int[][] dp) {
        if(x >= m){
            return 0;
        }
        if(dp[y][x] != NOT_VALID){
            return dp[y][x];
        }
        int result = 0;
        result = Math.max(result, cal((y+1)%2,x+2,map,n,m,dp));
        result = Math.max(result, cal((y+1)%2,x+1,map,n,m,dp));
        result += map[y][x];
        dp[y][x] = result;
        return result;
    }
}
