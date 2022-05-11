package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1981 {
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static boolean dfs(int[][] map , int y, int x , int diff,int max, int min,int n,boolean[][] visited){
        max = Math.max(max,map[y][x]);
        min = Math.min(min,map[y][x]);
        if(max - min > diff){
            return false;
        }
        if(y == n-1 && x == n-1){
            return true;
        }
        visited[y][x] = true;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx]){
                if(dfs(map,ny,nx,diff,max,min,n,visited)){
                    return true;
                }
            }
        }
        visited[y][x] = false;
        return false;
    }
    private static int binarySearch(int[][]map,int n){
        int max = 200;
        int min = 0;
        int result = max;
        while(min <= max){
            int mid = (max+min) / 2;
            boolean[][] visited = new boolean[n][n];
            boolean flag = dfs(map,0,0,mid,0,0,n,visited);
            if(flag){
                max = mid - 1;
                result = mid;
            }else{
                min = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        System.out.println(binarySearch(map,n));
    }
}
