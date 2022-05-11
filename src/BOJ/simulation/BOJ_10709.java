package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10709 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        char[][] map = new char[n][m];
        int[][] result = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            map[i] = br.readLine().toCharArray();
            Arrays.fill(result[i],-1);
        }
        bfs(map,result,n,m);
        printArr(result,n,m);
    }
    private static void printArr(int[][] arr,int n , int m){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void bfs(char[][] map, int[][] result,int n , int m) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 'c'){
                    q.offer(new int[] {i,j});
                    result[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
        int time = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                int ny = now[0];
                int nx = now[1]+1;
                if(checkBound(ny,nx,n,m) && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.offer(new int[] {ny,nx});
                    result[ny][nx] = time;
                }
            }
            time++;
        }
    }
    private static boolean checkBound(int y, int x, int n, int m){
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
