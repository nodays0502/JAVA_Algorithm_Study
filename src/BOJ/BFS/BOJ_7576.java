package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_7576 {
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    private static int bfs(int n , int m , int[][] map){
        Queue<int[]> q = new LinkedList<>();
//        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 1){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(checkMap(n,m,map)){
                return time;
            }
            for(int s = 0; s < size; s++){
                int[] now = q.poll();
                for(int i = 0 ; i < 4; i++){
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if(ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] == 0){
                        map[ny][nx] = 1;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
            time++;
        }
        return -1;
    }
    private static boolean checkMap(int n, int m, int[][]map){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int m = stoi.apply(st.nextToken());
        int n = stoi.apply(st.nextToken());
        int[][] map = new int [n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        System.out.println(bfs(n,m,map));
    }
}
