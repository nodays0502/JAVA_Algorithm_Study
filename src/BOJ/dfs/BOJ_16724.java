package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16724 {
    private static final String DIR = "URDL";
    private static final int NOT_VISITED = 0;
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
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
        int result = 0;
        int num = 1;
        int[][] visited = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(visited[i][j] == NOT_VISITED && dfs(i,j,map,n,m,visited,num++)){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    private static boolean dfs(int y, int x,char[][] map,int n, int m,int[][] visited, int num){
        visited[y][x] = num;
        int dir = DIR.indexOf(map[y][x]);
        int ny = y + DY[dir];
        int nx = x + DX[dir];
        if(visited[ny][nx] == NOT_VISITED){
            return dfs(ny,nx,map,n,m,visited,num);
        }else if(visited[ny][nx] == num){
            return true;
        }
        return false;
    }
    private static boolean checkBound(int y, int x, int n, int m){
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
