package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21609 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = 0;
        while(true){
            int temp = cal(map,n);
            if(temp == 0){
                break;
            }
            result += temp;
//            printArr(map,n);
        }
        System.out.println(result);
    }

    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};

    private static int cal(int[][] map,int n){
        int result = 0;
        int y = 0;
        int x = 0;
        int color = 0;
        int zeroCnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] > 0){
                    int[] temp = bfs(map,i,j,n);
                    if(temp[0] > result){
                        y = temp[1];
                        x = temp[2];
                        color = temp[3];
                        zeroCnt = temp[4];
                        result = temp[0];
                    }else if(temp[0] == result){
                        if(zeroCnt < temp[4]){
                            y = temp[1];
                            x = temp[2];
                            color = temp[3];
                            zeroCnt = temp[4];
                        }else if(zeroCnt == temp[4] && temp[1] > y){
                            y = temp[1];
                            x = temp[2];
                            color = temp[3];
                            zeroCnt = temp[4];
                        }else if((zeroCnt == temp[4] && temp[1] == y) && temp[2] > x){
                            y = temp[1];
                            x = temp[2];
                            color = temp[3];
                            zeroCnt = temp[4];
                        }
                    }
                }
            }
        }
        if(result <= 1){
            return 0;
        }

        remove(map,y,x,n,color);
        gravity(map,n);
        rotation(map,n);
        gravity(map,n);
        return result * result;
    }
    private static void printArr(int[][] map , int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(EMPTY == map[i][j]){
                    System.out.print("E ");
                }else{
                    System.out.print(map[i][j]+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void rotation(int[][] map, int n) {
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                temp[n-1-j][i] = map[i][j];
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                map[i][j] = temp[i][j];
            }
        }
    }

    private static void gravity(int[][] map, int n) {
        for(int j = 0 ; j < n ; j++){
            int emptyY = n-1;
            for(int i = n-1 ; i >= 0 ; i--){
                if(map[i][j] == -1){
                    emptyY = i-1;
                    continue;
                }
                if(map[i][j] != EMPTY && map[i][j] != -1){
                    int temp = map[i][j];
                    map[i][j] = EMPTY;
                    map[emptyY][j] = temp;

                    emptyY--;
                }
            }
        }
    }

    private static final int EMPTY = -100;
    private static void remove(int[][] map, int y, int x,int n,int color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        map[y][x] = EMPTY;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(checkBound(ny,nx,n) && (map[ny][nx] == color || map[ny][nx] == 0) ){
                    map[ny][nx] = EMPTY;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }

    private static int[] bfs(int[][] map, int y,int x,int n){
        int color = map[y][x];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        int zeroCnt = 0;
        int minY = y;
        int minX = x;
        boolean[][] visited = new boolean[n][n];
        visited[y][x] = true;
        int result = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            result++;
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(checkBound(ny,nx,n) && !visited[ny][nx] && (map[ny][nx] == color || map[ny][nx] == 0)){
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                    if(map[ny][nx] == 0){
                        zeroCnt++;
                    }
                    if(map[ny][nx] != 0 && minY > ny || (minY == ny && minX > nx)){
                        minY = ny;
                        minX = nx;
                    }
                }
            }
        }
        return new int[] {result,minY,minX,color,zeroCnt};
    }
    private static boolean checkBound(int y,int x,int n){
        if(y >= 0 && y < n && x >= 0 && x < n ){
            return true;
        }
        return false;
    }
}
