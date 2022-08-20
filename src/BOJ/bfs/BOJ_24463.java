package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_24463 {

    private static final char EMPTY = '.';
    private static final char VISITED = '.';
    private static final char BLOCK = '+';
    private static final char NOT_VISITED = '@';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        char[][] map = new char[n][m];
        int startY = -1;
        int startX = -1;
        int endY = -1;
        int endX = -1;
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = command.charAt(j);
                if (map[i][j] == EMPTY && (i == 0 || j == 0 || i == n - 1 || j == m - 1)) {
                    if (startY == -1) {
                        startY = i;
                        startX = j;
                    } else {
                        endY = i;
                        endX = j;
                    }
                }
            }
        }
        char[][] result = bfs(map, n, m, startY, startX, endY, endX);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                sb.append(result[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());

    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static char[][] bfs(char[][] map, int n, int m, int startY, int startX, int endY,
        int endX) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        q.offer(new int[] {startY,startX,1});
        int[][] dp = new int[n][m];
        int[][] dir = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                dir[i][j] = -1;
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == endY && now[1] == endX){
                break;
            }
            for(int i = 0 ; i < 4; i++){
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if(ny == startY && nx == startX){
                    continue;
                }
                if(checkBound(ny,nx,n,m) && (dp[ny][nx] == 0 || dp[ny][nx] > now[2]) && map[ny][nx] == EMPTY){
                    dp[ny][nx] = now[2];
                    q.offer(new int[]{ny,nx,now[2]+1});
                    dir[ny][nx] = (i + 4 - 2) % 4;
                }
            }
        }
        char[][] result = makeResult(map,dp,dir,n,m,endY,endX);

        return result;
    }

    private static char[][] makeResult(char[][] map,int[][] dp, int[][] dir, int n, int m,int endY,int endX) {
        char[][] result = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == BLOCK){
                    result[i][j] = map[i][j];
                }else{
                    result[i][j] = NOT_VISITED;
                }
            }
        }
        dfs(endY,endX,result,dir,n,m);

        return result;
    }

    private static void dfs(int y, int x, char[][] result, int[][] dir, int n, int m) {
        result[y][x] = VISITED;
        if(dir[y][x] == -1){
            return ;
        }
        int nowDir = dir[y][x];
        int ny = y + DY[nowDir];
        int nx = x + DX[nowDir];
        dfs(ny,nx,result,dir,n,m);
    }

    private static boolean checkBound(int ny, int nx, int n, int m) {
        if(ny >= 0 && ny < n && nx >= 0 && nx < m){
            return true;
        }
        return false;
    }
}
