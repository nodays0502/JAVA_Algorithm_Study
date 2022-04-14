package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_23288 {
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static final int LEFT = 3;
    private static final int RIGHT = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int[][]score = new int[n][m];
        boolean[][]visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j]){
                    bfs(score,map,i,j,visited,n,m);
                }
            }
        }
        int dir = 1;
        int[] position = {0,0,dir};
        int result  = 0;
        int[][] dice = {
            {0,2,0},
            {4,1,3},
            {0,5,0},
            {0,6,0}
        };
        for(int i = 0 ; i < k ; i++){
            result += move(position,map,score,n,m,dice);
        }
        System.out.println(result);
    }
    private static void moveDice(int[][] dice, int dir){
        if(dir == 0 || dir == 2){
            int prev = dice[1][1];
            int ny = 1;
            int nx = 1;
            for(int i = 0 ; i < 4 ; i++){
                ny += dy[dir];
                nx += dx[dir];
                if(checkBound(ny,nx,4,3)){

                }else if(ny < 0){
                    ny = 3;
                }else if(ny > 3){
                    ny = 0;
                }
                int temp = dice[ny][nx];
                dice[ny][nx] = prev;
                prev = temp;
            }
        }else{
            int prev = dice[1][1];
            int ny = 1;
            int nx = 1;
            for(int i = 0 ; i < 4 ; i++){
                ny += dy[dir];
                nx += dx[dir];
                if(checkBound(ny,nx,4,3) && ny == 3){
                    ny = 1;
                    nx -= 2*dx[dir];
                }else if(nx < 0){
                    ny = 3;
                    nx = 1;
                }else if(nx > 2){
                    ny = 3;
                    nx = 1;
                }
                int temp = dice[ny][nx];
                dice[ny][nx] = prev;
                prev = temp;
            }
        }
    }
    private static int move(int[] position, int[][] map, int[][] score, int n, int m,int[][] dice) {
        int y = position[0];
        int x = position[1];
        int dir = position[2];
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        if(!checkBound(ny,nx,n,m)){
            dir = (dir + 2) % 4;
            ny = y + dy[dir];
            nx = x + dx[dir];
        }
        moveDice(dice,dir);
        if(dice[3][1] > map[ny][nx]){
            dir = (dir + RIGHT) % 4;
        }
        if(dice[3][1] < map[ny][nx]){
            dir = (dir + LEFT) % 4;
        }
        position[0] = ny;
        position[1] = nx;
        position[2] = dir;
        return score[ny][nx];
    }

    private static void bfs(int[][] score, int[][] map, int y, int x,boolean[][] visited,int n, int m) {
        Queue<int[]> q = new LinkedList<> ();
        q.offer(new int[] {y,x});
        int cnt = 0;
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            cnt++;
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(checkBound(ny,nx,n,m) && !visited[ny][nx] && map[y][x] == map[ny][nx]){
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
        int result = cnt * map[y][x];
        q.offer(new int[]{y,x});
        score[y][x] = result;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(checkBound(ny,nx,n,m) && score[ny][nx] == 0 && map[y][x] == map[ny][nx]){
                    score[ny][nx] = result;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }
    private static boolean checkBound(int y, int x , int n , int m){
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
