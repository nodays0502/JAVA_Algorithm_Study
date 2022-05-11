package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14502 {
    public static int dfs(int depth, int y, int x, int[][]map, int n, int m){
        if(depth == 3){
            return bfs(map,n,m);
        }
        if(x >= m){
            y++;
            x = 0;
            if(y >= n){
                return 0;
            }
        }
        while(map[y][x] != 0){
            x++;
            if(x >= m){
                y++;
                x = 0;
                if(y >= n){
                    return 0;
                }
            }
        }
        int result = 0;
        result = Math.max(result,dfs(depth, y, x + 1, map, n, m));
        map[y][x] = 1;
        result = Math.max(result,dfs(depth + 1 ,y,x + 1,map,n,m));
        map[y][x] = 0;
        return result;
    }

    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};

    private static int bfs(int[][]map, int n ,int m){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 2){
                    q.offer(new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] != 1){
                    visited[ny][nx] = true;
                    q.offer(new int[] {ny,nx});
                }
            }
        }
        return calZero(map, visited, n, m);
    }
    private static int calZero(int[][]map, boolean[][] visited, int n, int m){
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    result++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
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
        System.out.println(dfs(0,0,0,map,n,m));
    }
}
