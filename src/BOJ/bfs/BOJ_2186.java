package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2186 {
    private static final int NOT_VALID = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        char[][] map = new char[n][];

        for(int i = 0 ; i < n ; i++){
                map[i] = br.readLine().toCharArray();
        }
        String command = br.readLine();
        int[][][] dp = new int[n][m][command.length()];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                Arrays.fill(dp[i][j],NOT_VALID);
            }
        }
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ;j++){
                cnt += dfs(0,i,j,command, map, n , m, k,dp);
            }
        }
        System.out.println(cnt);
    }

    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};

    private static int dfs(int depth,int y,int x, String command, char[][] map, int n, int m, int k,int[][][] dp) {
        if(command.charAt(depth) != map[y][x]){
            return 0;
        }
        if(dp[y][x][depth] != NOT_VALID){
            return dp[y][x][depth];
        }
        if(depth == command.length()-1){
            return 1;
        }
        int result = 0;
        for(int dir = 0 ; dir < 4; dir++){
            for(int length = 1; length <= k ; length++){
                int ny = y + length * dy[dir];
                int nx = x + length * dx[dir];
                if(!checkBound(ny,nx,n,m)){
                    break;
                }
                result += dfs(depth+1,ny,nx,command,map,n,m,k,dp);
            }
        }
        dp[y][x][depth] = result;
        return result;
    }
    private static boolean checkBound(int y ,int x , int n , int m){
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}

