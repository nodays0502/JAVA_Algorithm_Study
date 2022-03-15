package BOJ.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1981_2 {
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static boolean bfs(int[][] map , int n,int diff){
        int min = 0,max = 0;
        for(int num = 0 ; num <= 200 ; num++){
            min = num;
            max = num + diff;
            if(max > 200){
                break;
            }
            if(map[0][0] < min || map[0][0] > max){
                continue;
            }
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] {0,0});
            boolean[][] visited = new boolean[n][n];
            visited[0][0] = true;
            while(!q.isEmpty()){
                int[] now = q.poll();
                if(now[0] == n-1 && now[1] == n-1){
                    return true;
                }
                for(int i = 0 ; i < 4; i++){
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n
                        && map[ny][nx] >= min && map[ny][nx] <= max
                        && !visited[ny][nx]
                    ){
                        q.offer(new int[] {ny,nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return false;
    }
    private static int binarySearch(int[][]map,int n){
        int max = 200;
        int min = 0;
        int result = max;
        while(min <= max){
            int mid = (max + min) / 2;
            boolean[][] visited = new boolean[n][n];
            //int[][] map , int n,int diff
            boolean flag = bfs(map,n,mid);
            if(flag){
                max = mid - 1;
                result = Math.min(result,mid);
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
