package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j) - '0';
            }
        }
        boolean[][] visited = new boolean[n][m];
        int result = bfs(map,n,m);
//        int result = dfs(0,0,map,visited,n,m);
        System.out.println(result);
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static final int INF = 987654321; // 100 * 100
    private static final int EMPTY = 1;
    private static final int BLOCK = 0;
    private static int bfs(int[][]map,int n , int m){
        Queue<int[]> q = new LinkedList<>();
        int time = 1;
        q.offer(new int[]{0,0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(now[0] == n-1 && now[1] == m-1){
                    return time;
                }
                for(int i =  0 ; i < 4; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if(ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == BLOCK || visited[ny][nx]){
                        continue;
                    }
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }
            time++;
        }
        return -1;
    }

    private static int dfs(int y, int x,int[][]map,boolean[][] visited ,int n,int m){
        if(y == n-1 && x == m-1){
            return 1;
        }
        int result = INF;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + DY[i];
            int nx = x + DX[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == BLOCK || visited[ny][nx]){
                continue;
            }
            visited[ny][nx] = true;
            result = Math.min(result , dfs(ny,nx,map,visited,n,m)+1);
            visited[ny][nx] = false;
        }
        return result;
    }
}
