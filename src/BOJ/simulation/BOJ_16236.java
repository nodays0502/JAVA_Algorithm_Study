package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
    private static final int EMPTY = 0;
    private static final int SHARK = 9;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int sharkY = 0;
        int sharkX = 0;
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == SHARK){
                    map[i][j] = EMPTY;
                    sharkY = i;
                    sharkX = j;
                }
            }
        }
        int result = cal(sharkY,sharkX,map,n);
        System.out.println(result);
    }

    private static final int[] DY = {-1,0,0,1};
    private static final int[] DX = {0,-1,1,0};

    private static int cal(int sharkY, int sharkX, int[][] map, int n) {
        int time = 0;
        int sharkHeight = 2;
        int sharkEatCnt = 0;
        while(true){
            int[] position = bfs(sharkY,sharkX,sharkHeight,map,n);
            if(position == NOT_FOUND){
                break;
            }
            sharkEatCnt++;
            if(sharkEatCnt == sharkHeight){
                sharkHeight++;
                sharkEatCnt = 0;
            }
//            System.out.println(Arrays.toString(position));
            sharkY = position[0];
            sharkX = position[1];
            time += position[2];
            map[sharkY][sharkX] = EMPTY;
        }
        return time;
    }
    private static final int[] NOT_FOUND = new int[]{-1,-1};
    private static int[] bfs(int sharkY, int sharkX, int sharkHeight,int[][] map, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sharkY,sharkX});
        boolean[][] visited = new boolean[n][n];
        int time = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1,v2)->{
            if(v1[0] == v2[0]){
                return v1[1] - v2[1];
            }
            return v1[0]-v2[0];
        });

        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(map[now[0]][now[1]] != EMPTY && map[now[0]][now[1]] < sharkHeight){
                    pq.offer(now);
                }
                for(int i = 0 ; i < 4 ; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if(ny < 0 || ny >= n || nx < 0 || nx >= n || map[ny][nx] > sharkHeight || visited[ny][nx]){
                        continue;
                    }
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }
            if(!pq.isEmpty()){
                break;
            }
            time++;
        }
        if(pq.isEmpty()){
            return NOT_FOUND;
        }
        int[] position = pq.poll();
        return new int[]{position[0],position[1],time};
    }
}
