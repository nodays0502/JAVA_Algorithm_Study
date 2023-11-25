package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = cal(0,map,n);
        System.out.println(result);
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static int cal(int depth, int[][] map , int n){
        if(depth == 5){
//            printArr(map,n);
            return findMaxValue(map,n);
        }
        int result = 0;
        for(int i = 0 ; i < 4 ; i++){
            int[][] next = moveMap(i,map,n);
            result = Math.max(result,cal(depth+1,next,n));
        }
        return result;
    }
    private static final int EMPTY = 0;
    private static int[][] moveMap(int dir, int[][] map, int n) {
        int[][] next = copyMap(map,n);
        boolean[][] used = new boolean[n][n];
        if(dir == 0){ // 위
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(next[i][j] == EMPTY){
                        continue;
                    }
                    int y = i + DY[dir];
                    int x = j + DX[dir];
                    while(y >= 0 && y < n && x >= 0 && x < n && next[y][x] == EMPTY){
                        y += DY[dir];
                        x += DX[dir];
                    }
                    if(y >= 0 && y < n && x >= 0 && x < n && next[y][x] == next[i][j] && !used[y][x]){ // 같은 것 끼리 만났을 때
                        next[y][x] *= 2;
                        next[i][j] = EMPTY;
                        used[y][x] = true;
                        continue;
                    }
                    y -= DY[dir];
                    x -= DX[dir];
                    int value = next[i][j];
                    next[i][j] = EMPTY;
                    next[y][x] = value;
                }
            }
        }
        if(dir == 1){ // 오른쪽
            for(int i = 0 ; i < n ; i++){
                for(int j = n-1; j >= 0 ; j--){
                    if(next[i][j] == EMPTY){
                        continue;
                    }
                    int y = i + DY[dir];
                    int x = j + DX[dir];
                    while(y >= 0 && y < n && x >= 0 && x < n && next[y][x] == EMPTY){
                        y += DY[dir];
                        x += DX[dir];
                    }
                    if(y >= 0 && y < n && x >= 0 && x < n && next[y][x] == next[i][j] && !used[y][x]){ // 같은 것 끼리 만났을 때
                        next[y][x] *= 2;
                        next[i][j] = EMPTY;
                        used[y][x] = true;
                        continue;
                    }
                    y -= DY[dir];
                    x -= DX[dir];
                    int value = next[i][j];
                    next[i][j] = EMPTY;
                    next[y][x] = value;
                }
            }
        }
        if(dir == 2){ // 아래
            for(int i = n-1 ; i >= 0 ; i--){
                for(int j = 0 ; j < n ; j++){
                    if(next[i][j] == EMPTY){
                        continue;
                    }
                    int y = i + DY[dir];
                    int x = j + DX[dir];
                    while(y >= 0 && y < n && x >= 0 && x < n && next[y][x] == EMPTY){
                        y += DY[dir];
                        x += DX[dir];
                    }
                    if(y >= 0 && y < n && x >= 0 && x < n && next[y][x] == next[i][j] && !used[y][x]){ // 같은 것 끼리 만났을 때
                        next[y][x] *= 2;
                        next[i][j] = EMPTY;
                        used[y][x] = true;
                        continue;
                    }
                    y -= DY[dir];
                    x -= DX[dir];
                    int value = next[i][j];
                    next[i][j] = EMPTY;
                    next[y][x] = value;
                }
            }
        }
        if(dir == 3){ // 왼쪽
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(next[i][j] == EMPTY){
                        continue;
                    }
                    int y = i + DY[dir];
                    int x = j + DX[dir];
                    while(y >= 0 && y < n && x >= 0 && x < n && next[y][x] == EMPTY){
                        y += DY[dir];
                        x += DX[dir];
                    }
                    if(y >= 0 && y < n && x >= 0 && x < n && next[y][x] == next[i][j] && !used[y][x]){ // 같은 것 끼리 만났을 때
                        next[y][x] *= 2;
                        next[i][j] = EMPTY;
                        used[y][x] = true;
                        continue;
                    }
                    y -= DY[dir];
                    x -= DX[dir];
                    int value = next[i][j];
                    next[i][j] = EMPTY;
                    next[y][x] = value;
                }
            }
        }
        return next;
    }

    private static int findMaxValue(int[][] map, int n){
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                max = Math.max(max,map[i][j]);
            }
        }
        return max;
    }
    private static int[][] copyMap(int[][] map,int n){
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }
}