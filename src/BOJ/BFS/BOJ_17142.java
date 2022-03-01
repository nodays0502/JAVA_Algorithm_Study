package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17142 {
    private static int selectVirus(int[] isSelected,int depth, int start ,List<int[]> virus,int n,int m,int[][] map){
        if(depth == m){
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];
            for(int i = 0 ; i < m ; i++){
                int index = isSelected[i];
                int[] location = virus.get(index);
                q.offer(location);
                visited[location[0]][location[1]] = true;
            }
            return bfs(q,visited,n,map);
        }
        int result = -1;
        for(int i = start ; i < virus.size() ; i++){
            isSelected[depth] = i;
            int temp = selectVirus(isSelected,depth+1, i+1 ,virus,n, m, map);
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
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    private static int bfs(Queue<int[]> q,boolean[][] visited,int n,int[][] map){
        int time = 0;
        while(!q.isEmpty()){
            if(check(n,map,visited)){
                return time;
            }
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                for(int i = 0 ; i < 4; i++){
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] != 1){
                        visited[ny][nx] = true;
                        q.offer(new int[] {ny,nx});
                    }
                }
            }
            time++;
        }
        return -1;
    }
    private static boolean check(int n,int[][] map,boolean[][] visited){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if((map[i][j] != 1 && map[i][j] != 2) && !visited[i][j]){
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
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        List<int[]>  virus = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
                if(map[i][j] == 2){
                    virus.add(new int[] {i,j});
                }
            }
        }
        int[] isSelected = new int[m];
        System.out.println(selectVirus(isSelected,0,0 , virus,n,m, map));
    }
}
