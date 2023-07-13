package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1303 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int m = stoi.apply(st.nextToken());
        int n = stoi.apply(st.nextToken());
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        boolean[][] visited = new boolean[n][m];
        int[] result = new int[2];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j]){
                    int cnt = cal(i,j,map,visited,n,m);
                    if(map[i][j] == 'W'){
                        result[0] += cnt;
                    }else{
                        result[1] += cnt;
                    }
                }
            }
        }
        System.out.println(result[0]+" "+result[1]);
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static int cal(int y, int x, char[][] map, boolean[][] visited,int n,int m) {
        Queue<int[]> q = new LinkedList<>();
        int result = 1;
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && map[ny][nx] == map[y][x]){
                    result++;
                    q.offer(new int[]{ny,nx});
                    visited[ny][nx] = true;
                }
            }
        }
        return result * result;
    }
}
