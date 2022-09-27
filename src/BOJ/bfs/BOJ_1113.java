package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1113 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(command.charAt(j)+"");
            }
        }
//        for(int num = 1; num <= 9 ; num++){
//            for(int i = 0 ; i < n ; i++){
//                for(int j = 0 ; j < m ; j++){
//                    if(map[i][j] == num){
//                        result += bfs(i,j,map,n,m);
//                    }
//                }
//            }
//        }
//        System.out.println(result);
        boolean[][] visited = new boolean[n][m];
        for(int num = 1; num <= 9 ; num++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(map[i][j] == num && !visited[i][j]){
                        dfs(i,j,map,n,m,visited);
                    }
                }
            }
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println(answer);
    }
    private static final int INF = 10;
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static int answer = 0;
    private static int dfs(int y,int x,int[][] map ,int n, int m,boolean[][] visited){
        int result = INF;
        visited[y][x] = true;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + DY[i];
            int nx = x + DX[i];
            if(!checkBound(ny,nx,n,m) || map[ny][nx] < map[y][x]){
                return INF;
            }
            if(map[ny][nx] > map[y][x]){
                result = Math.min(result,map[ny][nx]);
                continue;
            }
            if(!visited[ny][nx] && map[ny][nx] == map[y][x]){
                int temp = dfs(ny,nx,map,n,m,visited);
                if(temp != INF){
                    result = Math.min(result,temp);
                }else{
                    return INF;
                }
            }
        }
        if(result != INF){
            visited[y][x] = false;
            answer += result - map[y][x];
            map[y][x] = result;
        }
        return result;
    }
    private static int bfs(int y, int x, int[][] map ,int n , int m) {
        boolean[][] tempVisited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        tempVisited[y][x] = true;
        q.offer(new int[] {y,x});
        int min = INF;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4; i++){
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if(!checkBound(ny,nx,n,m) || map[ny][nx] < map[y][x]){
                    return 0;
                }
                if(map[ny][nx] > map[y][x]){
                    min= Math.min(min,map[ny][nx]);
                    continue;
                }
                if(!tempVisited[ny][nx] && map[ny][nx] == map[y][x]){
                    tempVisited[ny][nx] = true;
                    q.offer(new int[] {ny,nx});
                }
            }
        }
        int result = min - map[y][x];
        map[y][x] = min;
        return result;
    }

    private static boolean checkBound(int y, int x, int n, int m){
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
