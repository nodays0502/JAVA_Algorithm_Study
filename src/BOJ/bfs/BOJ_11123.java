package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_11123 {
    private static final char SHEEP = '#';
    private static final char EMPTY = '.';


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int testCnt = stoi.apply(st.nextToken());
        for(int t = 0 ; t < testCnt ; t++){
            st = new StringTokenizer(br.readLine());
            int n = stoi.apply(st.nextToken());
            int m = stoi.apply(st.nextToken());
            char[][] map = new char[n][m];
            for(int i = 0 ; i < n ; i++){
                String command = br.readLine();
                for(int j = 0 ; j < m ; j++){
                    map[i][j] = command.charAt(j);
                }
            }
            int result = 0;
            boolean[][] visited = new boolean[n][m];
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(!visited[i][j] && map[i][j] == SHEEP){
                        bfs(i,j,map,visited,n,m);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static void bfs(int y, int x, char[][] map, boolean[][] visited,int n,int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
             int[] now = q.poll();
             for(int i = 0 ; i < 4; i++){
                 int ny = now[0] + DY[i];
                 int nx = now[1] + DX[i];
                 if(checkBound(ny,nx,n,m) && map[ny][nx] == SHEEP && !visited[ny][nx]){
                     q.offer(new int[] {ny,nx});
                     visited[ny][nx] = true;
                 }
             }
        }
    }

    private static boolean checkBound(int ny, int nx, int n, int m) {
        if( ny >= 0 && ny < n && nx >= 0 && nx < m){
            return true;
        }
        return false;
    }
}
