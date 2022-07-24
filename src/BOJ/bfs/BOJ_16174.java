package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16174 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        System.out.println(bfs(map,n));
    }
    private static final String FOUND = "HaruHaru";
    private static final String NOT_FOUND = "Hing";

    private static final int[] DY = {1,0};
    private static final int[] DX = {0,1};
    private static String bfs(int[][] map, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});
        boolean[][] visited = new boolean[n][n];
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == n-1 && now[1] == n-1){
                return FOUND;
            }
            int num = map[now[0]][now[1]];
            for(int i = 0 ; i < 2; i++){
                int ny = now[0] + num * DY[i];
                int nx = now[1] + num * DX[i];
                if(checkBound(ny,nx,n) && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
        return NOT_FOUND;
    }
    private static boolean checkBound(int y,int x,int n){
        if(y >= 0 && y < n && x >= 0 && x < n){
            return true;
        }
        return false;
    }
}
