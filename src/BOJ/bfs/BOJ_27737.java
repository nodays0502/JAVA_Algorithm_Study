package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_27737 {
    private static final int BLOCK = 1;
    private static final int EMPTY = 0;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String POSSIBLE = "POSSIBLE";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = cal(map,n,k);

        if(result > m || m == 0 || result == 0){
            System.out.println(IMPOSSIBLE);
        }else{
            System.out.println(POSSIBLE);
            System.out.println(m - result);
        }
    }

    private static int cal(int[][] map, int n, int k) {
        boolean[][] visited = new boolean[n][n];
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!visited[i][j] && map[i][j] == EMPTY){
                    cnt += bfs(i,j,map,visited,n,k);
                }
            }
        }
        return cnt;
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static int bfs(int y, int x, int[][] map, boolean[][]visited, int n, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            cnt++;
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if(ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx] && map[ny][nx] == EMPTY){
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
        int result = cnt / k;
        if(cnt % k != 0){
            result++;
        }
        return result;
    }
}
