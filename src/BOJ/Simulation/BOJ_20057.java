package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_20057 {
    private static final int[] dy = {0,1,0,-1};
    private static final int[] dx = {-1,0,1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        int y = n/2;
        int x= n/2;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int dir = 0;
        int dis = 1;
        int result = dfs(y,x,map,dir,dis,n);
        System.out.println(result);
    }

    private static int dfs(int y, int x, int[][] map,int dir, int dis,int n) {
        if(y == 0 && x == 0){
            return 0;
        }
        int ny = y;
        int nx = x;
        int result = 0;
        for(int i = 0 ; i < dis ; i++){
//            System.out.println(ny+" "+nx+" "+dir+" "+i);
            if(ny == 0 && nx == 0){
                break;
            }
            ny += dy[dir];
            nx += dx[dir];
            result += moveSend(ny,nx,dir,map,n);
        }
        if(dir % 2 != 0){
            dis++;
        }
        result += dfs(ny,nx,map,(dir+1)%4,dis,n);
        return result;
    }
    private static final int LEFT = 3;
    private static final int RIGHT = 1;
    private static int moveSend(int y, int x, int dir, int[][] map,int n) {
        int result = 0;
        int used = 0;
        int amount = map[y][x];
        if(amount == 0){
            return 0;
        }
        int nowDir = dir;
        int leftDir = (dir + LEFT) % 4;
        int rightDir = (dir + RIGHT) % 4;
        int ny = y + 2 * dy[nowDir];
        int nx = x + 2 * dx[nowDir];
        int nowAmount = amount * 5 / 100;
        used += nowAmount;
        result += move(ny,nx,map,n,nowAmount);

        ny = y + dy[nowDir] + dy[leftDir];
        nx = x + dx[nowDir] + dx[leftDir];
        nowAmount = amount * 10 / 100;
        used += nowAmount;
        result += move(ny,nx,map,n,nowAmount);

        ny = y + dy[nowDir] + dy[rightDir];
        nx = x + dx[nowDir] + dx[rightDir];
        nowAmount = amount * 10 / 100;
        used += nowAmount;
        result += move(ny,nx,map,n,nowAmount);

        ny = y + dy[leftDir];
        nx = x + dx[leftDir];
        nowAmount = amount * 7 / 100;
        used += nowAmount;
        result += move(ny,nx,map,n,nowAmount);

        ny = y + dy[rightDir];
        nx = x + dx[rightDir];
        nowAmount = amount * 7 / 100;
        used += nowAmount;
        result += move(ny,nx,map,n,nowAmount);

        ny = y + 2 * dy[leftDir];
        nx = x + 2 * dx[leftDir];
        nowAmount = amount * 2 / 100;
        used += nowAmount;
        result += move(ny,nx,map,n,nowAmount);

        ny = y + 2 * dy[rightDir];
        nx = x + 2 * dx[rightDir];
        nowAmount = amount * 2 / 100;
        used += nowAmount;
        result += move(ny,nx,map,n,nowAmount);

        ny = y - dy[nowDir] + dy[leftDir];
        nx = x - dx[nowDir] + dx[leftDir];
        nowAmount = amount * 1 / 100;
        used += nowAmount;
        result += move(ny,nx,map,n,nowAmount);

        ny = y - dy[nowDir] + dy[rightDir];
        nx = x - dx[nowDir] + dx[rightDir];
        nowAmount = amount * 1 / 100;
        used += nowAmount;
        result += move(ny,nx,map,n,nowAmount);

        ny = y + dy[nowDir];
        nx = x + dx[nowDir];
        nowAmount = amount - used;
        result += move(ny,nx,map,n,nowAmount);
        return result;
    }
    private static int move(int y,int x,int[][]map,int n,int amount){
        if(checkBound(y,x,n)){
            map[y][x] += amount;
            return 0;
        }else{
            return amount;
        }
    }
    private static boolean checkBound(int y,int x, int n){
        if(y < 0 || y >= n || x < 0 || x >= n ){
            return false;
        }
        return true;
    }
}
