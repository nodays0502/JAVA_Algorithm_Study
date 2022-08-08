package BOJ.simulation;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17822 {
    private static final int EMPTY = 0;
    private static final int CLOCKWISE = 0;
    private static final int COUNTERCLOCKWISE = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int t = stoi.apply(st.nextToken());
        int[][] input = new int[n+1][m];

        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                input[i][j] = stoi.apply(st.nextToken());
            }
        }
        for(int i = 0 ; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int x = stoi.apply(st.nextToken());
            int d = stoi.apply(st.nextToken());
            int k = stoi.apply(st.nextToken());
            rotate(input,x,d,k,n,m);
            checkNear(input,n,m);
        }
        System.out.println(calScore(input,n,m));
    }
    private static void print(int[][]input,int n,int m){
        for(int i = 1 ; i <= n ; i++){
            System.out.println(Arrays.toString(input[i]));
        }
        System.out.println();
    }
    private static int calScore(int[][] input, int n, int m) {
        int sum = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < m ; j++){
                sum += input[i][j];
            }
        }
        return sum;
    }

    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};

    private static void checkNear(int[][] input, int n, int m) {
        boolean[][] near = new boolean[n+1][m];
        boolean findNear = false;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int dir = 0 ; dir < 4; dir++){
                    int ny = i + DY[dir];
                    if(ny < 1 || ny > n) {
                        continue;
                    }
                    int nx = j + DX[dir];
                    if(nx < 0){
                        nx = m-1;
                    }
                    if(nx >= m){
                        nx = 0;
                    }
                    if(input[i][j] == input[ny][nx] && input[i][j] != EMPTY){
                        findNear = true;
                        near[i][j] = true;
                        near[ny][nx] = true;
                    }
                }
            }
        }
        if(!findNear){
            int sum = 0;
            int cnt = 0;
            for(int i = 1 ; i <= n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(input[i][j] != EMPTY){
                        cnt++;
                        sum += input[i][j];
                    }
                }
            }
            double avg = (double)sum/cnt;
            for(int i = 1 ; i <= n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(input[i][j] == EMPTY){
                        continue;
                    }
                    if(input[i][j] > avg ){
                        input[i][j]--;
                        continue;
                    }
                    if(input[i][j] < avg){
                        input[i][j]++;
                        continue;
                    }
                }
            }
            return;
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(near[i][j]){
                    input[i][j] = EMPTY;
                }
            }
        }
    }

    private static void rotate(int[][] input, int x, int d, int k, int n, int m) {
        for(int i = 1 ; i <= n ; i++){
            if(i % x == 0){
                for(int a = 0 ; a < k ; a++){

                    if(d == CLOCKWISE){

                        int prev = input[i][m-1];
                        for(int j = 0 ; j < m ; j++){
                            int temp = input[i][j];
                            input[i][j] = prev;
                            prev = temp;
                        }
                    }else{
                        int prev = input[i][0];
                        for(int j = m-1 ; j >= 0 ; j--){
                            int temp = input[i][j];
                            input[i][j] = prev;
                            prev = temp;
                        }
                    }
                }
            }
        }
    }
}
