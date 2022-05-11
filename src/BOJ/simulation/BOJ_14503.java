package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14503 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int y = stoi.apply(st.nextToken());
        int x = stoi.apply(st.nextToken());
        int dir = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        boolean[][] isClean = new boolean[n][m];
        dfs(map,y,x,n,m,dir,isClean);
        int result = calClean(isClean,n,m);
        System.out.println(result);
    }

    private static int calClean(boolean[][] isClean, int n, int m) {
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(isClean[i][j]){
                    result++;
                }
            }
        }
        return result;
    }

    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static void dfs(int[][] map, int y, int x, int n, int m, int dir, boolean[][] isClean) {
        isClean[y][x] = true;
//        int nextDir = dir;
//        nextDir = (dir + 3) % 4;
//        int ny = y + dy[nextDir];
//        int nx = x + dx[nextDir];
//        if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != 1 && !isClean[ny][nx]){ // 1
//            dfs(map,ny,nx,n,m,nextDir,isClean);
//        }else{
//
//        }
        int nextDir = dir;
        for(int i = 0 ; i < 4 ; i++){
            nextDir--;
            if(nextDir < 0){
                nextDir = 3;
            }
            int ny = y + dy[nextDir];
            int nx = x + dx[nextDir];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != 1 && !isClean[ny][nx]){ // a, b
                dfs(map,ny,nx,n,m,nextDir,isClean);
                return ;
            }
        }
        nextDir = (dir + 2) % 4;
        int ny = y + dy[nextDir];
        int nx = x + dx[nextDir];
        if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != 1){ // a, b
            dfs(map,ny,nx,n,m,dir,isClean);
            return ;
        }
        return ;
    }
}
