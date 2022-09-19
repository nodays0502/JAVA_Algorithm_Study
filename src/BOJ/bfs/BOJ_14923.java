package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14923 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startY = stoi.apply(st.nextToken())-1;
        int startX = stoi.apply(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        int endY = stoi.apply(st.nextToken())-1;
        int endX = stoi.apply(st.nextToken())-1;

        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = bfs(map,startY,startX,endY,endX,n,m);
        System.out.println(result);
    }

    private static final int NOT_FOUND = -1;
    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};

    private static int bfs(int[][] map, int startY, int startX, int endY, int endX, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startY,startX,0});
        boolean[][][] visited = new boolean[n][m][2];
        visited[startY][startX][0] = true;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(now[0] == endY && now[1] == endX){
                    return time;
                }
                int cnt = now[2];
                for(int i = 0 ; i < 4 ; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if(checkBound(ny,nx,n,m) && !visited[ny][nx][cnt] && map[ny][nx] == EMPTY){
                        visited[ny][nx][cnt] = true;
                        q.offer(new int[] {ny,nx,cnt});
                    }
                    if(checkBound(ny,nx,n,m) && !visited[ny][nx][cnt] && map[ny][nx] == WALL && cnt == 0){
                        visited[ny][nx][cnt+1] = true;
                        q.offer(new int[] {ny,nx,cnt+1});
                    }
                }
            }
            time++;
        }
        return NOT_FOUND;
    }

    private static boolean checkBound(int ny, int nx, int n, int m) {
        if(ny >= 0 && ny < n && nx >= 0 && nx < m){
            return true;
        }
        return false;
    }
}
