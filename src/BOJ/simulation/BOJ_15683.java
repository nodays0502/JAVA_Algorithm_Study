package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15683 {
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static final int[][] type = {
        {},
        {4,0},
        {2,1,3},
        {4,0,1},
        {4,0,1,2},
        {1,0,1,2,3}
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        List<int[]> cctv = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6){
                    cctv.add(new int[] {i,j});
                }
            }
        }
        int result = dfs(cctv.size()-1,cctv,map,n,m);
        System.out.println(result);
    }

    private static int dfs(int depth, List<int[]> cctv, int[][] map, int n, int m) {
        if(depth == -1){
            return count(map,n,m);
        }
        int y = cctv.get(depth)[0];
        int x = cctv.get(depth)[1];
        int nowType = map[y][x];
        int rotationCnt = type[nowType][0];
        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i < rotationCnt ; i++){
            int[][] temp = copyOf(map,n,m);
            for(int j = 1 ; j < type[nowType].length ; j++){
                int dir = type[nowType][j];
                dir = (dir + i) % 4;
                paintRoute(temp,y,x,n,m,dir);
            }
            result = Math.min(result, dfs(depth-1,cctv,temp,n,m));
        }
        return result;
    }

    private static void paintRoute(int[][] map,int y,int x, int n, int m, int dir) {
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        while(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != 6){
//            System.out.println(ny+" "+nx);
            if(map[ny][nx] == 0){
                map[ny][nx] = 8;
            }
            ny += dy[dir];
            nx += dx[dir];
        }
    }


    private static int[][] copyOf(int[][] arr,int n,int m){
        int[][] temp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }
    private static int count(int[][] map , int n , int m){
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 0){
                    result++;
                }
            }
        }
        return result;
    }
}
