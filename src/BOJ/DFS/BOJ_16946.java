package BOJ.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;

public class BOJ_16946 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        String command = br.readLine();
        String[] temp = command.split(" ");
        int n = stoi.apply(temp[0]);
        int m = stoi.apply(temp[1]);
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(command.charAt(j)+"");
            }
        }
        int[][] result = new int[n][m];
        int[][] bound = new int[n][m];
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    bfs(bound,list,i,j,n,m,visited,map);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                sb.append(cal(map,bound,n,m,i,j,list));
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    private static int cal(int[][] map, int[][] bound, int n, int m, int y, int x, List<Integer> list) {
        if(map[y][x] == 0){
            return 0;
        }
        int result = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 0 && !set.contains(bound[ny][nx])){
                set.add(bound[ny][nx]);
                result += list.get(bound[ny][nx]);
            }
        }
        result %= 10;
        return result;
    }

    private static void bfs(int[][] bound, List<Integer> list,int y, int x, int n, int m,boolean[][] visited,int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        int result = 1;
        visited[y][x] = true;
        int boundValue = list.size();
        bound[y][x] = boundValue;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ;i < 4; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && map[ny][nx] == 0){
                    result++;
                    visited[ny][nx] = true;
                    bound[ny][nx] = boundValue;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
        list.add(result % 10);
    }
}
