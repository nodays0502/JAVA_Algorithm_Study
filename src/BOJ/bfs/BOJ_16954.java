package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16954 {

    private static final int SIZE = 8;
    private static final char EMPTY = '.';
    private static final char BLOCK = '#';
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[SIZE][SIZE];
        for(int i = 0 ; i < SIZE ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < SIZE ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        int result = bfs(map);
        System.out.println(result);
    }

    private static final int[] DY = {0,-1,0,1,0,-1,1,1,-1};
    private static final int[] DX = {0,0,1,0,-1,1,1,-1,-1};

    private static int bfs(char[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {SIZE-1,0});
        boolean[][] visited;
        while(!q.isEmpty()){
            int size = q.size();
            visited = new boolean[SIZE][SIZE];
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(now[0] == 0 && now[1] == SIZE-1){
                    return SUCCESS;
                }
                if(map[now[0]][now[1]] == BLOCK){
                    continue;
                }
                for(int i = 0 ; i < 9; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if(checkBound(ny,nx) && !visited[ny][nx] && map[ny][nx] == EMPTY){
                        visited[ny][nx] = true;
                        q.offer(new int[] {ny,nx});
                    }
                }
            }
            moveMap(map);
        }
        return FAIL;
    }

    private static void moveMap(char[][] map) {
        for(int i = 0 ; i < SIZE ; i++){
            for(int j = SIZE-1 ; j >= 0 ; j--){
                if(j == 0){
                    map[j][i] = EMPTY;
                    continue;
                }
                map[j][i] = map[j-1][i];
            }
        }
    }

    private static boolean checkBound(int ny, int nx) {
        if(ny >= 0 && ny < SIZE && nx >= 0 && nx < SIZE){
            return true;
        }
        return false;
    }
}
