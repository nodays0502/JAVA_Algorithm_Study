package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_18405 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n  = stoi.apply(st.nextToken());
        int k  = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine()," ");

        int s = stoi.apply(st.nextToken());
        int y = stoi.apply(st.nextToken())-1;
        int x = stoi.apply(st.nextToken())-1;

        bfs(map,n,s);

        System.out.println(map[y][x]);
    }

    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static final int EMPTY = 0;
    private static final int INF = 987654321;

    private static void bfs(int[][] map,int n,int limitTime) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return o1[0] - o2[0];
        });
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] != EMPTY){
                    pq.offer(new int[]{map[i][j],i,j});
                }
            }
        }
        int time = 0;
        Queue<int[]> nextPq = new LinkedList<>();
        while(!pq.isEmpty()){
            if(time >= limitTime){
                break;
            }
            int size = pq.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = pq.poll();
                for(int dir = 0 ; dir < 4 ; dir++){
                    int ny = now[1] + dy[dir];
                    int nx = now[2] + dx[dir];
                    if(checkBound(ny,nx,n) && map[ny][nx] == EMPTY ){
                        map[ny][nx] = now[0];
                        nextPq.offer(new int[]{map[ny][nx],ny,nx});
                    }
                }
            }
            time++;

            while(!nextPq.isEmpty()){
                pq.offer(nextPq.poll());
            }

        }
    }

    private static boolean checkBound(int ny, int nx, int n) {
        if(ny >= 0 && ny < n && nx >= 0 && nx < n){
            return true;
        }
        return false;
    }
}
