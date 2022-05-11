package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2638 {
    private static int cal(int[][]map,int n , int m){
        int time = 0;
        while(!checkAllMelted(map,n,m)){
            time++;
            int[][] airConnectCnt = checkAirCnt(map, n, m);
            meltCheeze(airConnectCnt,map,n,m);
        }
        return time;
    }
    private static final int dy[] = {-1,0,1,0};
    private static final int dx[] = {0,1,0,-1};

    private static int[][] checkAirCnt(int[][]map, int n, int m){
        boolean[][] visited = new boolean[n+2][m+2];
        int[][] airConnectCnt = new int[n+2][m+2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny >= 0 && ny < n+2 && nx >= 0 && nx < m+2 && !visited[ny][nx] && map[ny][nx] == 0){
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(map[i][j] == 1){
                    airConnectCnt[i][j] = checkLocationAirCnt(i,j,map,n,m,visited);
                }
            }
        }
        return airConnectCnt;
    }
    private static void meltCheeze(int[][] airConnectCnt, int[][]map, int n, int m){
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(airConnectCnt[i][j] >= 2){
                    map[i][j] = 0;
                }
            }
        }
    }
    private static int checkLocationAirCnt(int y,int x,int[][]map, int n, int m,boolean[][] visited){
        int cnt = 0;
        for(int i = 0 ; i < 4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(nx >= 1 && nx <= m && ny >= 1 && ny <= n && map[ny][nx] == 0 && visited[ny][nx]){
                cnt++;
            }
        }
        return cnt;
    }
    private static boolean checkAllMelted(int[][]map , int n , int m){
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(map[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n+2][m+2];
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 1 ; j <= m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        System.out.println(cal(map, n , m));
    }
}
