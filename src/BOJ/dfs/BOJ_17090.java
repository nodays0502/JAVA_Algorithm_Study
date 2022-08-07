package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17090 {
    private static final int NOT_VISITED = 0;
    private static final int VISITED = 2;
    private static final int ESCAPE = 1;
    private static final int NO_ESCAPE = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        int[][] visited = new int[n][m];
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if((visited[i][j] == NOT_VISITED && dfs(i,j,map,n,m,visited) == ESCAPE) || visited[i][j] == ESCAPE){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static final String DIRECTION = "URDL";
    private static int dfs(int y,int x,char[][] map, int n, int m, int[][] visited) {
        if(visited[y][x] == VISITED){
            return NO_ESCAPE;
        }
        if(visited[y][x] != NOT_VISITED){
            return visited[y][x];
        }
        visited[y][x] = VISITED;
        int dir = DIRECTION.indexOf(map[y][x]);
        int ny = y + DY[dir];
        int nx = x + DX[dir];
        if(checkBound(ny,nx,n,m)){
            return visited[y][x] = dfs(ny,nx,map,n,m,visited);
        }else{
            return visited[y][x] = ESCAPE;
        }
    }

    private static boolean checkBound(int ny, int nx, int n, int m) {
        if(ny >= 0 && ny < n && nx >= 0 && nx < m){
            return true;
        }
        return false;
    }
}
