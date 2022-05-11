package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_12100 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        System.out.println(bfs(map,n));
    }

    private static int bfs(int[][] map, int n) {
        Queue<int[][]> q = new LinkedList<>();
        q.offer(map);
        Set<String> visited = new HashSet<>();
        int result  = 0;
        int time = 0;
        q.offer(map);
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[][] now = q.poll();
//                System.out.println("time:"+time+" "+Arrays.deepToString(now));
                result = Math.max(checkMaxValue(now,n),result);// 0 - 처음
                for(int i = 0 ; i < 2; i++){
                    int[][] temp = moveUpOrRight(now,n,i);
//                    System.out.println(i+" "+Arrays.deepToString(temp));
                    if(!visited.contains(Arrays.deepToString(temp))){
                        q.offer(temp);
                    }
                }
                for(int i = 2; i < 4; i++){
                    int[][] temp = moveDownOrLeft(now,n,i);
//                    System.out.println(i+" "+Arrays.deepToString(temp));
                    if(!visited.contains(Arrays.deepToString(temp))){
                        q.offer(temp);
                    }
                }
            }
            if(time == 5){
                break;
            }
            time++;
        }
        return result;
    }
    private static int checkMaxValue(int[][] arr , int n){
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                result = Math.max(result,arr[i][j]);
            }
        }
        return result;
    }
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,-1,0,1};
    private static int[][] moveUpOrRight(int[][] arr , int n , int dir){
        int[][] temp = arrCopy(arr,n);
        boolean[][] used = new boolean[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] != 0){
                    move(temp,n,i,j,dir,used);
                }
            }
        }
        return temp;
    }
    private static int[][] moveDownOrLeft(int[][] arr , int n , int dir){
        int[][] temp = arrCopy(arr,n);
        boolean[][] used = new boolean[n][n];
        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = n-1 ; j >= 0 ; j--){
                if(arr[i][j] != 0){
                    move(temp,n,i,j,dir,used);
                }
            }
        }
        return temp;
    }
    private static void move(int[][]arr , int n , int y, int x,int dir,boolean[][] used){
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        while(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[ny][nx] == 0){
            ny += dy[dir];
            nx += dx[dir];
        }
        if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[y][x] == arr[ny][nx] && !used[ny][nx]){
            arr[ny][nx] *= 2;
            arr[y][x] = 0;
            used[ny][nx] = true;
            return ;
        }
        ny -= dy[dir];
        nx -= dx[dir];
        if(ny != y || nx != x){
            arr[ny][nx] = arr[y][x];
            arr[y][x] = 0;
        }
        return ;
    }
    private static int[][] arrCopy(int[][] arr , int n){
        int[][]temp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }
}
