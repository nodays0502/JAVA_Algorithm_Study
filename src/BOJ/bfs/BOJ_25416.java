package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_25416 {
    private static final int SIZE = 5;
    private static final int BLOCK = -1;
    private static final int TARGET = 1;
    private static final int EMPTY = 0;
    private static final int NOT_FOUND = -1;
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Function<String,Integer> stoi = Integer::parseInt;
        int[][] map = new int[SIZE][SIZE];
        for(int i = 0 ; i < SIZE ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < SIZE ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int startY = stoi.apply(st.nextToken());
        int startX = stoi.apply(st.nextToken());
        int result = bfs(startY,startX,map);
        System.out.println(result);
    }

    private static int bfs(int startY, int startX, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startY,startX});
        int time = 0;
        boolean[][] visited = new boolean[SIZE][SIZE];
        visited[startY][startX] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(map[now[0]][now[1]] == TARGET){
                    return time;
                }
                for(int i = 0 ; i < 4; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if(ny >= 0 && ny < SIZE && nx >= 0 && nx < SIZE && !visited[ny][nx] && map[ny][nx] != BLOCK){
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
            time++;
        }
        return NOT_FOUND;
    }
}
