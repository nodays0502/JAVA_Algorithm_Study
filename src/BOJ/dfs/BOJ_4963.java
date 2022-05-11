package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_4963 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Function<String,Integer> stoi = Integer::parseInt;
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            int m = stoi.apply(st.nextToken());
            int n = stoi.apply(st.nextToken());
            if(n == 0 && m == 0){
                break;
            }
            int[][] map = new int[n][m];
            int islandCnt = 0;
            boolean[][] visited = new boolean[n][m];
            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0 ; j < m ; j++){
                    map[i][j] = stoi.apply(st.nextToken());
                }
            }
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        islandCnt++;
                        dfs(i,j,map,visited,n,m);
                    }
                }
            }
            System.out.println(islandCnt);
        }
    }
    private static final int[] dy = {-1,0,1,0,-1,1,1,-1};
    private static final int[] dx = {0,1,0,-1,1,1,-1,-1};
    private static void dfs(int y, int x, int[][] map,boolean[][] visited,int n , int m) {
        visited[y][x] = true;
        for(int i = 0 ; i < 8 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] == 1){
                dfs(ny,nx,map,visited,n,m);
            }
        }
    }
}
