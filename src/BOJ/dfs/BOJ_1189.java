package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1189 {
    private static final char BLOCK = 'T';
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        boolean[][] visited = new boolean[n][m];
        int result = cal(1,n-1,0,n,m,k,visited,map);
        System.out.println(result);
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static int cal(int depth, int y, int x, int n, int m, int k,boolean[][] visited,char[][] map) {
        if(depth == k && y == 0 && x == m-1){
            return 1;
        }
        if(depth >= k){
            return 0;
        }
        visited[y][x] = true;
        int result = 0;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + DY[i];
            int nx = x + DX[i];
            if(ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && map[ny][nx] != BLOCK){
                result += cal(depth+1,ny,nx,n,m,k,visited,map);
            }
        }
        visited[y][x] = false;
        return result;
    }
}
