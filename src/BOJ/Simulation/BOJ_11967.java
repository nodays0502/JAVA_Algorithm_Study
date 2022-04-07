package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_11967 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<int[]>[][] switches = new List[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                switches[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int y = stoi.apply(st.nextToken())-1;
            int x = stoi.apply(st.nextToken())-1;
            int a = stoi.apply(st.nextToken())-1;
            int b = stoi.apply(st.nextToken())-1;
            switches[y][x].add(new int[] {a,b});
        }
        int result = bfs(switches,n);
        System.out.println(result);
    }
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static int bfs(List<int[]>[][] switches, int n) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        boolean[][] isLight = new boolean[n][n];
        visited[0][0] = true;
        isLight[0][0] = true;
        q.offer(new int[] {0,0});
        for(int j = 0 ; j < switches[0][0].size() ; j++){
            int[] next = switches[0][0].get(j);
            isLight[next[0]][next[1]] = true;
        }
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                int y = now[0];
                int x = now[1];
                for(int i = 0 ; i < 4; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(boundCheck(ny,nx,n) && isLight[ny][nx] && !visited[ny][nx]){
//                        System.out.println( (ny+1)+" "+(nx+1) );
                        flag = true;
                        visited[ny][nx] = true;
                        q.offer(new int[] {ny,nx});
                        for(int j = 0 ; j < switches[ny][nx].size() ; j++){
                            int[] next = switches[ny][nx].get(j);
                            isLight[next[0]][next[1]] = true;
                        }
                    }
                }
                q.offer(now);
            }
            if(!flag){
                break;
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isLight[i][j]){
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean boundCheck(int y, int x, int n) {
        if(y >= 0 && y < n && x >= 0 && x < n){
            return true;
        }
        return false;
    }
}
