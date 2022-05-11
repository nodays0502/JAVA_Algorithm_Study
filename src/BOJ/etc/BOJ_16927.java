package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16927 {
    static private final int[] dy = {1,0,-1,0};
    static private final int[] dx = {0,-1,0,1};
    static private void rotate(int[][] arr, int k, int n, int m){
        int[][] temp = new int[n][m];
        for(int depth = 0 ; depth < Math.min(n,m)/2 ; depth++) {
            Queue<Integer> q = new LinkedList<>();
            int ny = depth;
            int nx = m - 1 - depth;
            for(int i = 0 ; i < 4 ; i++){
                ny += dy[i];
                nx += dx[i];
                while(ny >= depth && ny < n - depth && nx >= depth && nx < m - depth){
                    q.offer(arr[ny][nx]);
                    ny += dy[i];
                    nx += dx[i];
                }
                ny -= dy[i];
                nx -= dx[i];
            }
            int cnt = k % q.size();
            for(int i = 0 ; i < cnt ; i++){
                int num = q.poll();
                q.offer(num);
            }
            ny = depth;
            nx = m - 1- depth;
            for(int i = 0 ; i < 4 ; i++){
                ny += dy[i];
                nx += dx[i];
                while(ny >= depth && ny < n - depth && nx >= depth && nx < m - depth){
                    arr[ny][nx] = q.poll();
                    ny += dy[i];
                    nx += dx[i];
                }
                ny -= dy[i];
                nx -= dx[i];
            }
//            print(arr,n,m);
//            System.out.println("-----------------------------");
        }
    }
    static private void print(int[][] arr, int n , int m){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                arr[i][j] = stoi.apply(st.nextToken());
            }
        }
        rotate(arr,k,n,m);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
