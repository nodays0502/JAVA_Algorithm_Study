package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1012 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < testCnt ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[][] vegetable = new boolean[n][m];
            for(int i = 0 ; i < k ; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                vegetable[y][x] = true;
            }
            boolean[][] visited = new boolean[n][m];
            int cnt = 0;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(vegetable[i][j] && !visited[i][j]){
                        cnt++;
                        bfs(i,j,vegetable,visited,n,m);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int y, int x, boolean[][] vegetable, boolean[][] visited, int n, int m) {
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] || !vegetable[ny][nx]){
                    continue;
                }
                q.offer(new int[]{ny,nx});
                visited[ny][nx] = true;
            }
        }
    }

    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
}
