package Programmers.ETC;

import java.util.Arrays;

public class 보행자_천국 {
    private static int MOD = 20170805;
    private static int[] dy = {1,0};
    private static int[] dx = {0,1};
    private static int GO_STRAIGHT = 2;
    private static int NOT_VALID = -1;
    private static int BLOCK = 1;
    public int solution(int n, int m, int[][] cityMap) {
        int[][][] dp = new int[n][m][2];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                Arrays.fill(dp[i][j],NOT_VALID);
            }
        }
        int answer = dfs(0,0,0,cityMap,n,m,dp);
        return answer;
    }
    private static int dfs(int y ,int x, int dir,int[][] map,int n,int m,int[][][] dp){
        if(y == n-1 && x == m-1){
            return 1;
        }
        if(dp[y][x][dir] != NOT_VALID){
            return dp[y][x][dir];
        }
        int result = 0;
        for(int i = 0 ; i < 2 ; i++){
            if(map[y][x] == GO_STRAIGHT && i != dir){
                continue;
            }
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(checkBound(ny,nx,n,m) && map[ny][nx] != BLOCK){
                result += dfs(ny,nx,i,map,n,m,dp);
                result %= MOD;
            }
        }
        dp[y][x][dir] = result;
        return result;
    }
    private static boolean checkBound(int y,int x,int n,int m){
        if(y >=0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
