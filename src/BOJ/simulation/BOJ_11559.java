package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11559 {

    private static final char EMPTY = '.';
    private static final int HEIGHT = 12;
    private static final int WIDTH = 6;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[HEIGHT][WIDTH];
        for(int i = 0 ; i < HEIGHT ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < WIDTH ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        int result = cal(map);
        System.out.println(result);
    }

    private static int cal(char[][] map) {
        int cnt = 0;
        while(true){
            boolean haveBomb = false;
            boolean[][] bomb = new boolean[HEIGHT][WIDTH];
            for(int i = 0 ; i < HEIGHT; i++){
                for(int j = 0 ; j < WIDTH ; j++){
                    if(map[i][j] != EMPTY && !bomb[i][j] &&check(i,j,map,bomb)){
                        haveBomb = true;
                    }
                }
            }
            if(!haveBomb){
                break;
            }
            for(int i = 0 ; i < HEIGHT; i++){
                for(int j = 0 ; j < WIDTH ; j++){
                    if(bomb[i][j]){
                        map[i][j] = EMPTY;
                    }
                }
            }
            gravity(map);
            cnt++;
        }
        return cnt;
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static boolean check(int y,int x,char[][] map, boolean[][] bomb) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        boolean[][] visited = new boolean[HEIGHT][WIDTH];
        visited[y][x] = true;
        int cnt = 0;
        char color = map[y][x];
        while(!q.isEmpty()){
            int[] now = q.poll();
            cnt++;
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if(ny >= 0 && ny < HEIGHT && nx >= 0 && nx < WIDTH && !visited[ny][nx] && map[ny][nx] == color){
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
        if(cnt < 4){
            return false;
        }
        for(int i = 0 ; i < HEIGHT ; i++) {
            for(int j = 0 ; j < WIDTH ; j++){
                if(visited[i][j]){
                    bomb[i][j] = true;
                }
            }
        }
        return true;
    }

    private static void gravity(char[][] map){
        for(int width = 0 ; width < WIDTH ; width++){
            int index = HEIGHT-1;
            for(int height = HEIGHT-1 ; height >= 0  ; height--){
                if(map[height][width] != EMPTY){
                    char temp = map[index][width];
                    map[index][width] = map[height][width];
                    map[height][width] = temp;
                    index--;
                }
            }
        }
    }

}