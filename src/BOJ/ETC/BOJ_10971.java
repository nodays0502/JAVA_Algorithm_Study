package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;
import javax.swing.text.View;

public class BOJ_10971 {

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
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int result = dfs(0,0,map,n,visited);
        System.out.println(result);
    }
    private static final int INF = 87_654_321;
    private static int dfs(int depth,int now, int[][] map, int n, boolean[] visited) {
        if(depth == n-1 && map[now][0] != 0) {
            return map[now][0];
        }
        if(depth == n-1){
            return INF;
        }
        int result = INF;
        for(int i = 0 ; i < n ; i++){
            if(visited[i] || map[now][i] == 0){
                continue;
            }
            visited[i] = true;
            result = Math.min(result,map[now][i] + dfs(depth+1,i,map,n,visited));
            visited[i] = false;
        }
        return result;
    }
}
