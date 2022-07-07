package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_2151 {
    private static final char EMPTY = '.';
    private static final char WALL = '*';
    private static final char MIRROR = '!';
    private static final char DOOR = '#';
    private static final int NOT_VALID = -1;
    private static final int INF = 987654321;
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        char[][] map = new char[n][n];
        Position start = null;
        Position end = null;
        for(int i = 0 ; i < n ; i ++){
            String command = br.readLine();
            for(int j = 0 ; j < n ; j++){
                map[i][j] = command.charAt(j);
                if(map[i][j] == DOOR){
                    if(start == null){
                        start = new Position(i,j);
                    }else{
                        end = new Position(i,j);
                    }
                }
            }
        }
        int[][][] dp = new int[n][n][4];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j++){
                Arrays.fill(dp[i][j],NOT_VALID);
            }
        }
        int result = INF;
        for(int i = 0 ; i < 4 ; i++){
            result = Math.min(result,dfs(end,start.y, start.x,i,dp,map,n));
        }
        System.out.println(result);
    }
    private static int dfs(Position end,int y,int x,int dir, int[][][] dp,char[][] map, int n){
        if(end.isSame(y,x)){
            return 0;
        }

        if(dp[y][x][dir] != NOT_VALID){
            return dp[y][x][dir];
        }
        if(map[y][x] == WALL){
            return INF;
        }
        if(map[y][x] == EMPTY || map[y][x] == DOOR){
            int ny = y + DY[dir];
            int nx = x + DX[dir];
            if(checkBound(ny,nx,n) && map[ny][nx] != WALL){
                return dfs(end,ny,nx,dir,dp,map,n);
            }else{
                return INF;
            }
        }

        int result = INF;
        for(int i = -1 ; i <= 1 ; i++){
            int nextDir = (dir + i + 4) % 4;
            int ny = y + DY[nextDir];
            int nx = x + DX[nextDir];
            if(checkBound(ny,nx,n)){
                result = Math.min(result,dfs(end,ny,nx,nextDir,dp,map,n)+1);
            }
        }
        dp[y][x][dir] = result;
        return result;
    }
    private static boolean checkBound(int y,int x,int n){
        if(y >= 0 && y < n && x >= 0 && x < n){
            return true;
        }else{
            return false;
        }
    }
}
