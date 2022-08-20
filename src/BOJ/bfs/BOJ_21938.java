package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21938 {
    private static final int COLOR_SIZE = 3;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] pixel = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                for(int k = 0 ; k < COLOR_SIZE; k++){
                    pixel[i][j] += stoi.apply(st.nextToken());
                }
                pixel[i][j] /= COLOR_SIZE;
            }
        }
        int limit = stoi.apply(br.readLine());
        int[][] map = makeMap(pixel,limit,n,m);
        boolean[][] visited = new boolean[n][m];
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == OBJECT && !visited[i][j]){
                    result++;
                    bfs(i,j,map,n,m,visited);
                }
            }
        }
        System.out.println(result);
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static void bfs(int y,int x,int[][] map, int n, int m, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4; i++){
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if(checkBound(ny,nx,n,m) && !visited[ny][nx] && map[ny][nx] == OBJECT){
                    visited[ny][nx] = true;
                    q.offer(new int[] {ny,nx});
                }
            }
        }
    }

    private static boolean checkBound(int ny, int nx, int n, int m) {
        if(ny >= 0 && ny < n && nx >= 0 && nx < m){
            return true;
        }
        return false;
    }

    private static final int OBJECT = 255;
    private static int[][] makeMap(int[][] pixel, int limit, int n, int m) {
        int[][] result = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(pixel[i][j] >= limit){
                    result[i][j] = OBJECT;
                }
            }
        }
        return result;
    }
}
