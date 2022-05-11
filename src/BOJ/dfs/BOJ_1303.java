package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_1303 {
    static final int[] dy = {-1,0,1,0};
    static final int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        String[] str = command.split(" ");
        Function<String,Integer> stoi = Integer::parseInt;
        int m = stoi.apply(str[0]);
        int n = stoi.apply(str[1]);
        char map[][] = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        int[] result = new int[2];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && map[i][j] == 'W'){
                    result[0] += Math.pow(dfs(map,n,m,i,j,visited),2);
                }else if(!visited[i][j] && map[i][j] == 'B'){
                    result[1] += Math.pow(dfs(map,n,m,i,j,visited),2);
                }
            }
        }
        System.out.println(result[0]+" "+result[1]);
    }

    private static int dfs(char[][] map, int n, int m, int y, int x, boolean[][] visited) {
        visited[y][x] = true;
        int result = 1;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && map[ny][nx] == map[y][x]){
                result += dfs(map,n,m,ny,nx,visited);
            }
        }
        return result;
    }
}
