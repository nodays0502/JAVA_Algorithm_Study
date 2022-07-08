package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1388 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j =0  ;j < m ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        int result = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0  ;j < m ; j++){
                if(!visited[i][j]){
                    checkCnt(i, j,map,n,m,visited);
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    private static final String FLOOR_TYPE = "-|";
    private static final int[] DY = {0,1};
    private static final int[] DX = {1,0};
    private static void checkCnt(int y,int x,char[][] map, int n, int m,boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        char nowCh = map[y][x];
        while(!q.isEmpty()){
            int[] now = q.poll();
            visited[now[0]][now[1]] = true;
            int type = FLOOR_TYPE.indexOf(map[now[0]][now[1]]);
            int ny = now[0] + DY[type];
            int nx = now[1] + DX[type];
            if(checkBound(ny,nx,n,m) && !visited[ny][nx] && map[ny][nx] == nowCh ){
                q.offer(new int[]{ny,nx});
            }
        }
    }
    private static boolean checkBound(int y,int x,int n,int m){
        if(x >= 0 && x < m && y >= 0 && y < n){
            return true;
        }
        return false;
    }
}
