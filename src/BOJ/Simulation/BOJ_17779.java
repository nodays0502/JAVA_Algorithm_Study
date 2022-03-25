package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17779 {
    private static final int[] dy = {-1,1,1,-1};
    private static final int[] dx = {1,1,-1,-1};
    private static int[][] makeBoundary(int y, int x, int n, int d1,int d2){
        int[][]boundary = new int[n][n];
        int ny = y;
        int nx = x;
        for(int i = 0 ; i < 4 ; i++){
            int size = d1;
            if(i % 2 != 0){
                size = d2;
            }
            for(int j = 0 ; j < size ; j++){
                ny += dy[i];
                nx += dx[i];
                boundary[ny][nx] = 5;
            }

        }
        fillBoundary(boundary,n,y,x,d1,d2);
        return boundary;
    }
    private static void fillBoundary(int[][]boundary,int n,int y,int x,int d1, int d2){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int nowY = i + 1;
                int nowX = j + 1;
                if(boundary[i][j] == 5){
                    break;
                }

                if( i < y && j <= x + d1){ // 1  1 ≤ r < x+d1, 1 ≤ c ≤ y
                    boundary[i][j] = 1;
                }
                if(i >= y && j < x + d2){
                    boundary[i][j] = 3;
                }
            }
            for(int j = n-1 ; j >= 0 ; j--){
                int nowY = i + 1;
                int nowX = j + 1;
                if(boundary[i][j] == 5 || boundary[i][j] == 1 || boundary[i][j] == 3){
                    break;
                }
                if( i <= y - d1 + d2 ){ // 2 1 ≤ r ≤ x+d2, y < c ≤ N
                    boundary[i][j] = 2;
                }else{
                    boundary[i][j] = 4;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n;  i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i < n;  i++){
            for(int j = 0 ; j < n ; j++){
                for(int d1 = 1 ; d1 < n ; d1++){
                    for(int d2 = 1; d2 < n ; d2++){
                        if(j + d1 + d2 >= n || i-d1 < 0 || i + d2 >= n){
                            break;
                        }
                        int[][] boundary = makeBoundary(i, j, n, d1, d2);
                        result = Math.min(result,cal(map,boundary,n));
                    }
                }
            }
        }
        System.out.println(result);
    }
    private static int cal(int[][]map , int[][] boundary,int n){
        int[] sum = new int[5+1];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j  < n ; j++){
                int area = boundary[i][j];
                sum[area] += map[i][j];
            }
        }
        sum[5] += sum[0];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= 5 ; i++){
            max = Math.max(max,sum[i]);
            min = Math.min(min,sum[i]);
        }
        return max - min;
    }
}
