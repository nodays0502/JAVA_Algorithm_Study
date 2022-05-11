package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17086 {
    private static final int[] dy = {-1,0,1,0,-1,1,1,-1};
    private static final int[] dx = {0,1,0,-1,1,1,-1,-1};
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
        int result = bfs(map,n,m);
        System.out.println(result);
    }

    private static int bfs(int[][] map, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][]  visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 1){
                    q.offer(new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }
        int time = -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                for(int i = 0 ; i < 8 ; i++){
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx]){
                        q.offer(new int[]{ny,nx});
                        visited[ny][nx] = true;
                    }
                }
            }
            time++;
        }
        return time;
    }
}
