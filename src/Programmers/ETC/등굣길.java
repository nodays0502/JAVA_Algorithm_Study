package Programmers.ETC;

public class 등굣길 {
    private static final int LIMIT = 1_000_000_007;
    private static final int[] DY = {1,0};
    private static final int[] DX = {0,1};
    private static final boolean EMPTY = false;
    private static final boolean WATER = true;
    private static final int NOT_VALID = -1;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        boolean[][] map = new boolean[n][m];
        int[][] dp = new int[n][m];
        for(int i = 0  ;i < n ; i++){
            Arrays.fill(dp[i], NOT_VALID);
        }
        for(int[] puddle : puddles){
            int y = puddle[1] -1;
            int x = puddle[0] -1;
            map[y][x] = WATER;
        }
        answer = dfs(0,0,n,m,map,dp);
        return answer;
    }
    private int dfs(int y,int x,int n,int m,boolean[][] map,int[][]dp){
        if(y == n-1 && x == m-1){
            return 1;
        }
        if(map[y][x] == WATER){
            return 0;
        }
        if(dp[y][x] != NOT_VALID){
            return dp[y][x];
        }
        long result = 0;
        for(int i = 0 ; i < 2; i++){
            int ny = y + DY[i];
            int nx = x + DX[i];
            if(checkBound(ny,nx,n,m)){
                result += dfs(ny,nx,n,m,map,dp);
                result %= LIMIT;
            }
        }
        dp[y][x] = (int)result;
        return (int)result;
    }
    private boolean checkBound(int y,int x,int n,int m){
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
