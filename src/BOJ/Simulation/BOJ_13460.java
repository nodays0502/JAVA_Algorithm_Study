package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13460 {

    private static int bfs(char[][] map, int n, int m, int[] red, int[] blue){
        Queue<int[]> q = new LinkedList<>(); // red y , red x , blue y , blue x
        boolean[][][][] visited = new boolean[n][m][n][m];
        q.offer(new int[] {red[0],red[1],blue[0],blue[1]});
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
        int time = 1;
        while(!q.isEmpty()){
            int size = q.size();
            if(time > 10){
                break;
            }
            for(int s = 0 ; s < size; s++){
                int[] now = q.poll();
                for(int i = 0 ; i < 4; i++){
                    int[] nowRed = {now[0],now[1]};
                    int[] nowBlue = {now[2],now[3]};
                    boolean flag = moveBiz(map, n,m,nowRed,nowBlue,i);
                    if(flag) {
                        return time;
                    }
                    if(!visited[nowRed[0]][nowRed[1]][nowBlue[0]][nowBlue[1]] && map[nowBlue[0]][nowBlue[1]] != 'O') {
                        visited[nowRed[0]][nowRed[1]][nowBlue[0]][nowBlue[1]] = true;
                        q.offer(new int [] {nowRed[0],nowRed[1],nowBlue[0],nowBlue[1]});
                    }
                }
            }
            time++;
        }
        return -1;
    }
    private static boolean moveBiz(char[][]map, int n, int m , int[] biz1 , int[] biz2, int dir){
        boolean redGoTarget = false;
        boolean blueGoTarget = false;
        redGoTarget = move(map,n,m,biz1,biz2,dir);
        blueGoTarget = move(map,n,m,biz2,biz1,dir);
        redGoTarget = redGoTarget || move(map,n,m,biz1,biz2,dir);
        return redGoTarget && !blueGoTarget;
    }
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static boolean move (char[][]map, int n, int m , int[] biz,int[] tempBiz, int dir){
        int ny = biz[0];
        int nx = biz[1];
        ny += dy[dir];
        nx += dx[dir];
        while(ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] != '#' ){
            if(map[ny][nx] == 'O'){
                biz[0] = ny;
                biz[1] = nx;
                return true;
            }
            if(tempBiz[0] == ny && tempBiz[1] == nx){
                break;
            }
            ny += dy[dir];
            nx += dx[dir];
        }
        ny -= dy[dir];
        nx -= dx[dir];
        biz[0] = ny;
        biz[1] = nx;
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        char[][] map = new char[n][m];
        int[] red = new int[2];
        int[] blue = new int[2];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
                if(map[i][j] == 'R'){
                    red[0] = i;
                    red[1] = j;
                    map[i][j] = '.';
                }
                if(map[i][j] == 'B'){
                    blue[0] = i;
                    blue[1] = j;
                    map[i][j] = '.';
                }
            }
        }
        System.out.println(bfs(map,n,m,red,blue));
    }
}
