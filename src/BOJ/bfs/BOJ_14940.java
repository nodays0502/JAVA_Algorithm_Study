package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14940 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] input = new int[n][m];
        int[][] distance = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(distance[i],NOT_FOUND);
        }
        int startY = 0;
        int startX = 0;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                input[i][j] = stoi.apply(st.nextToken());
                if(input[i][j] == START_POINT){
                    startY = i;
                    startX = j;
                }
                if(input[i][j] == WALL){
                    distance[i][j] = WALL;
                }
            }
        }


        bfs(startY,startX,input,n,m,distance);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static final int START_POINT = 2;
    private static final int WALL = 0;
    private static final int NOT_FOUND = -1;
    private static int[][] bfs(int startY,int startX, int[][] input, int n, int m, int[][] distance) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startY,startX});
        boolean[][] visited = new boolean[n][m];
        visited[startY][startX] = true;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
//                System.out.println(Arrays.toString(now));
                distance[now[0]][now[1]] = time;
                for(int i = 0 ; i < 4 ; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if(checkBound(ny,nx,n,m) && !visited[ny][nx] && input[ny][nx] != WALL){
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
            time++;
        }
        return distance;
    }

    private static boolean checkBound(int ny, int nx, int n, int m) {
        if(ny >= 0 && ny < n && nx >= 0 && nx < m){
            return true;
        }
        return false;
    }
}
