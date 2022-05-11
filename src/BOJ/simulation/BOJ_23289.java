package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_23289 {
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[][] map = new int[n+2][m+2];
        int[][] temperature = new int[n+2][m+2];
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 1 ; j <= m ; j++){
                int num = stoi.apply(st.nextToken());
                map[i][j] = changeDir(num);
            }
        }
        boolean[][][] barrier = new boolean[n+2][m+2][4];
        int cnt = stoi.apply(br.readLine());
        for(int i = 0 ; i < cnt ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int y = stoi.apply(st.nextToken());
            int x = stoi.apply(st.nextToken());
            int type = stoi.apply(st.nextToken());
            makeBarrier(barrier,y,x,type);
        }
        System.out.println(cal(temperature,map,barrier,n,m,k));
    }
    private static final int EMPTY = -1;
    private static final int CHECK_POINT = 5;
    private static int cal(int[][] temperature, int[][] map,boolean[][][] barrier,int n, int m,int k){
        int result = 0;
        while(true){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= m ; j++){
                    if(map[i][j] != EMPTY && map[i][j] != CHECK_POINT){
                        onAirCondition(i,j,temperature,map[i][j],barrier,n,m);

                    }
                }
            }
//            printArr(temperature,n,m);
            controlAir(temperature,barrier,n,m);
            decreaseOutsideAir(temperature,n,m);
//            printArr(temperature,n,m);
            result++;
            if(result > 100){
                break;
            }

            if(checkCheckPoint(map,temperature,n,m,k)){
                return result;
            }
        }
        return 101;
    }
    private static void printArr(int[][] arr, int n, int m) {
        for(int i = 1 ; i <= n ; i++){
            for(int j= 1; j <= m ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void decreaseOutsideAir(int[][] temperature, int n, int m) {
        int dir = 1;
        int ny = 1;
        int nx = 1;
        while(true){
            ny += dy[dir];
            nx += dx[dir];
            while(checkBound(ny,nx,n,m)){
                if(temperature[ny][nx] > 0){
                    temperature[ny][nx]--;
                }
                ny += dy[dir];
                nx += dx[dir];
            }
            ny -= dy[dir];
            nx -= dx[dir];
            dir = (dir + 1) % 4;
            if(dir == 1){
                break;
            }
        }
    }

    private static boolean checkCheckPoint(int[][] map,int[][] temperature, int n, int m, int k) {
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++) {
                if (map[i][j] == CHECK_POINT && temperature[i][j] < k) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void controlAir(int[][] temperature,boolean[][][] barrier, int n, int m) {
        int[][] temp = new int[n+2][m+2];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= m ; j++){
                int sum = 0;
                for(int k = 0 ; k < 4; k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(checkBound(ny,nx,n,m) && !barrier[i][j][k]){
                        int num = (temperature[i][j] - temperature[ny][nx]) / 4;
                        if(num > 0){
                            temp[ny][nx] += num;
                            sum += num;
                        }
                    }
                }
                temp[i][j] -= sum;
            }
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= m ; j++){
                temperature[i][j] += temp[i][j];
            }
        }
    }

    private static void onAirCondition(int i, int j, int[][] temperature, int dir, boolean[][][] barrier, int n,
        int m) {
        Queue<int[]> q= new LinkedList<>();
        boolean [][] visited = new boolean[n+2][m+2];
        int ny = i + dy[dir];
        int nx = j + dx[dir];
        int time = 5;
        if(checkBound(ny,nx,n,m)){
            q.offer(new int[] {ny,nx});
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                int y = now[0];
                int x = now[1];
                temperature[y][x] += time;
                ny = y + dy[dir];
                nx = x + dx[dir];
                if(!barrier[y][x][dir] && checkBound(ny,nx,n,m) && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.offer(new int[] {ny,nx});
                }
                int tempDir = (dir + 1) % 4;
                int tempNy = ny + dy[tempDir];
                int tempNx = nx + dx[tempDir];
                if(!barrier[y][x][tempDir] && checkBound(tempNy,tempNx,n,m) && !barrier[y+dy[tempDir]][x+dx[tempDir]][dir] && !visited[tempNy][tempNx]){
                    visited[tempNy][tempNx] = true;
                    q.offer(new int[] {tempNy,tempNx});
                }
                tempDir = (dir + 3) % 4;
                tempNy = ny + dy[tempDir];
                tempNx = nx + dx[tempDir];

                if(!barrier[y][x][tempDir] && checkBound(tempNy,tempNx,n,m) && !barrier[y+dy[tempDir]][x+dx[tempDir]][dir] && !visited[tempNy][tempNx]){
                    visited[tempNy][tempNx] = true;
                    q.offer(new int[] {tempNy,tempNx});
                }

            }
            time--;
            if(time <= 0){
                break;
            }
        }
    }
    private static boolean checkBound(int y , int x , int n , int m){
        if(y >= 1 && y <= n && x >= 1 && x <= m){
            return true;
        }
        return false;
    }

    private static void makeBarrier(boolean[][][] barrier, int y, int x, int type) {
        int ny = y;
        int nx = x;
        if(type == 1){
            nx++;
            barrier[y][x][1] = true;
            barrier[ny][nx][3] = true;
        }else{
            ny--;
            barrier[y][x][0] = true;
            barrier[ny][nx][2] = true;
        }
    }

    private static int changeDir(int num){
        if(num == 0){
            return EMPTY;
        }
        if(num == 1){
            return 1;
        }
        if(num == 2){
            return 3;
        }
        if(num == 3){
            return 0;
        }
        if(num == 4){
            return 2;
        }
        return num;
    }
}
