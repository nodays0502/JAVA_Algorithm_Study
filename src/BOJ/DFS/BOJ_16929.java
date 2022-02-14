package BOJ.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16929 {

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
        boolean[][] visited = new boolean[n][m];
        boolean flag = false;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j]){
                    flag = dfs(i,j,-1,-1,visited,n,m,map[i][j],map);
                }
                if(flag){
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        if(flag){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    static final int[] dy = {-1,0,1,0};
    static final int[] dx = {0,1,0,-1};
    private static boolean dfs(int y, int x, int prevy, int prevx, boolean[][] visited, int n, int m,char ch,char[][] map) {
        visited[y][x] = true;
        boolean flag = false;
        for(int i = 0 ; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if((ny != prevy || nx != prevx) && (ny >= 0 && ny < n && nx >= 0 && nx < m) && map[ny][nx] == ch){
                if(visited[ny][nx]){
                    flag = true;
                }else{
                    flag = dfs(ny,nx,y,x,visited,n,m,ch,map);
                }
                if(flag){
                    break;
                }
            }
        }
        return flag;
    }

}
