package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16933 {
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static int cal(char[][] map, int n, int m, int k){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0,0}); // y,x,벽 부순 횟수
        boolean visited[][][] = new boolean[n][m][k+1];
        visited[0][0][0] = true;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int nextDay = (time + 1) % 2;
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                int cnt = now[2];
                if(now[0] == n-1 && now[1] == m-1){
                    return time + 1;
                }
                for(int i = 0 ; i < 4 ; i++){
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                        if(map[ny][nx] == '0' && !visited[ny][nx][cnt]){
                            visited[ny][nx][cnt] = true;
                            q.offer(new int[] {ny,nx,cnt});
                        }
                        if(map[ny][nx] == '1' && cnt < k){
                            if(time % 2 == 0  && !visited[ny][nx][cnt+1]){
                                visited[ny][nx][cnt+1] = true;
                                q.offer(new int[] {ny,nx,cnt+1});
                            }else if(time % 2  != 0 && !visited[ny][nx][cnt+1]){
                                q.offer(new int[] {now[0], now[1], cnt});
                            }
                        }
                    }
                }
            }
            time++;
        }
        return -1;
    }
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
        System.out.println(cal(map,n,m,k));
    }
}

