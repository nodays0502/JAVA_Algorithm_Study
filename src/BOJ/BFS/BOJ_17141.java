package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17141 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        System.out.println(cal(map,n,m));
    }
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static int cal(int[][] map, int n , int m){
        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] == 2){
                    list.add(new int[] {i,j});
                }
            }
        }
        int[] virus = new int[m];
        int result = choice(0, 0, list, m, virus,map,n);
        return result;
    }

    private static int choice(int depth, int start,List<int[]> list, int m,int[] virus,int[][]map,int n) {
        if(depth == m){
            boolean[][] visited = new boolean[n][n];
            Queue<int[]> q = new LinkedList<>();
            for(int i = 0 ; i < m ; i++){
                int[] location = list.get(virus[i]);
                q.offer(location);
                visited[location[0]][location[1]] = true;
            }
            return bfs(q,map,n,visited);
        }
        int result = -1;
        for(int i = start ; i < list.size(); i++){
            virus[depth] = i;
            int temp = choice(depth+1,i+1,list,m,virus,map,n);
            if(temp != -1){
                if(result == -1){
                    result = temp;
                }else{
                    result = Math.min(result,temp);
                }
            }
        }
        return result;
    }

    private static int bfs(Queue<int[]> q,int[][] map, int n,boolean[][] visited) {
        int time = -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                for(int i = 0 ; i < 4 ; i++){
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if(ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx] && map[ny][nx] != 1){
                        q.offer(new int[] {ny,nx});
                        visited[ny][nx] = true;
                    }
                }
            }
            time++;
        }
        if(check(map,n,visited)){
            return time;
        }else{
            return -1;
        }
    }
    private static boolean check(int[][] map,int n,boolean[][] visited){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!visited[i][j] && map[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
