package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16918 {
    private static final char BOMB = 'O';
    private static final char EMPTY = '.';
    private static final int INT_EMPTY = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int t = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                char ch = command.charAt(j);
                if(ch == EMPTY){
                    map[i][j] = INT_EMPTY;
                }else{
                    map[i][j] = 1;
                }
            }
        }
        cal(map,n,m,t);
    }
    private static void cal(int[][]map,int n,int m,int t){
        int time = 2;
        while(time <= t){
            if(time % 2 == 0){
                putBomb(map,n,m,time);
            }else{
                if(time == 3){
                    bomb(map,n,m,time-2);
                }else{
                    bomb(map,n,m,time-3);
                }
            }
//            System.out.println(time);
//            print(map,n,m);
            time++;
        }
        printMap(map,n,m);
    }
    private static void print(int[][] map , int n , int m){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    private static void printMap(int[][] map , int n , int m){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == INT_EMPTY){
                    sb.append(EMPTY);
                }else{
                    sb.append(BOMB);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    private static void putBomb(int[][]map,int n,int m,int time){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == INT_EMPTY){
                    map[i][j] = time;
                }
            }
        }
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static void bomb(int[][]map,int n,int m,int time){
        boolean[][] check = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == time){
                    check[i][j] = true;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(check[i][j]){
                    map[i][j] = INT_EMPTY;
                    for(int k = 0 ; k < 4 ; k++){
                        int ny = i + DY[k];
                        int nx = j + DX[k];
                        if(ny >= 0 && ny < n && nx >= 0 && nx < m){
                            map[ny][nx] = INT_EMPTY;
                        }
                    }
                }
            }
        }
    }
}
