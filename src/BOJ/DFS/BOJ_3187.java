package BOJ.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_3187 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n =  stoi.apply(st.nextToken());
        int m =  stoi.apply(st.nextToken());
        char[][] map = new char[n][m];
        for(int i =  0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        boolean[][] visited = new boolean[n][m];
        int[] result = new int[2];
        for(int i =  0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && map[i][j] != '#'){
                    int[] temp = dfs(map,i,j,visited,n,m);
                    if(temp[0] <= temp[1]){
                        temp[0] = 0;
                    }else{
                        temp[1] = 0;
                    }
                    result[0] += temp[0];
                    result[1] += temp[1];
                }
            }
        }
        System.out.println(result[0] +" "+result[1]);
    }
    static final int dy[] = {-1,0,1,0};
    static final int dx[] = {0,1,0,-1};
    private static int[] dfs(char[][] map, int y, int x, boolean[][] visited,int n , int m) {
        visited[y][x] = true;
        int[] result = new int[2];
        if(map[y][x] == 'k'){
            result[0]++;
        }else if(map[y][x] == 'v'){
            result[1]++;
        }
        for(int i = 0 ; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx >= 0 && nx < m && ny>=0 && ny < n && !visited[ny][nx] && map[ny][nx] != '#'){
                int[] temp = dfs(map,ny,nx,visited,n,m);
                result[0] += temp[0];
                result[1] += temp[1];
            }
        }
        return result;
    }
}
