package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16930 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int startY = stoi.apply(st.nextToken()) - 1;
        int startX = stoi.apply(st.nextToken()) - 1;
        int endY = stoi.apply(st.nextToken()) - 1;
        int endX = stoi.apply(st.nextToken()) - 1;
        System.out.println(bfs(map,n,m,k,startY,startX,endY,endX));
    }

    private static  int bfs(char[][] map, int n ,int m , int k, int startY, int startX, int endY, int endX) {
        final int dy[] = {-1,0,1,0};
        final int dx[] = {0,1,0,-1};
        Queue<int[]> q = new LinkedList< >();
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[] {startY,startX});
        visited[startY][startX] = true;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(now[0] == endY && now[1] == endX){
                    return time;
                }
                for(int i = 0 ; i < 4 ; i++){
                    int ny = now[0];
                    int nx = now[1];
                    for(int j = 1 ; j <= k ; j++){
                        ny += dy[i];
                        nx += dx[i];
                        if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == '.'){
                            if(!visited[ny][nx]){
                                visited[ny][nx] = true;
                                q.offer(new int[]{ny,nx});
                            }
                        }else{
                            break;
                        }
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
