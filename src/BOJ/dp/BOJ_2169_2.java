package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2169_2 {
    private static final int[] DY = {0,1,0};
    private static final int[] DX = {-1,0,1};
    private static final int DOWN = 1;
    private static final int INF = 100 * 1_000 * 1_000;
    private static final int NOT_VALID = 987654321;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }

        int[][][] dp = new int[n][m][3];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                Arrays.fill(dp[i][j],NOT_VALID);
            }
        }
        int result = dfs(0,0,DOWN,map,n,m,dp);
        System.out.println(result);
    }
    private static int dfs(int y , int x,int dir, int[][] map, int n, int m, int[][][] dp) {
        if(y == n-1 && x == m-1){
            return map[y][x];
        }
        if(dp[y][x][dir] != NOT_VALID){
            return dp[y][x][dir];
        }
        int result = -INF;
        for(int nextDir = 0 ; nextDir < 3 ; nextDir++){
            if( (dir != DOWN) && (nextDir !=DOWN) && (dir != nextDir)){
                continue;
            }
            int ny = y + DY[nextDir];
            int nx = x + DX[nextDir];
            if(!checkBound(ny,nx,n,m)){
                continue;
            }
            result = Math.max(result,dfs(ny,nx,nextDir,map,n,m,dp));
        }
        dp[y][x][dir] = result + map[y][x];
        return dp[y][x][dir];
    }
    private static boolean checkBound(int y ,int x , int n,int m){
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
