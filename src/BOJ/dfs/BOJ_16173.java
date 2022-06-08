package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16173 {

    private static final String SUCCESS = "HaruHaru";
    private static final String FAIL = "Hing";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] input = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                input[i][j] = stoi.apply(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[n][n];
        if(dfs(0,0,input,visited,n)){
            System.out.println(SUCCESS);
        }else{
            System.out.println(FAIL);
        }
    }

    private static final int[] dy = {0,1};
    private static final int[] dx = {1,0};
    private static final int GOAL = -1;

    private static boolean dfs(int y, int x,int[][] input, boolean[][] visited,int n) {
        visited[y][x] = true;
        if(input[y][x] == GOAL){
            return true;
        }
        int length = input[y][x];
        boolean result = false;
        for(int i = 0 ; i < 2 ; i++){
            int ny = y + length * dy[i];
            int nx = x + length * dx[i];
            if(checkBound(ny,nx,n) && !visited[ny][nx] && dfs(ny,nx,input,visited,n)){
                result = true;
                break;
            }
        }
        return result;
    }
    private static boolean checkBound(int y ,int x, int n){
        if(y >= 0 && y < n && x >= 0 && x < n ){
            return true;
        }
        return false;
    }
}
