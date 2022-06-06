package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2234 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int m = stoi.apply(st.nextToken());
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int num = 1;
        int[][] area = new int[n][m];
        int[] results = new int[3];
        List<Integer> size = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(area[i][j] == 0){
                    int nowSize = bfs(i,j,map,n,m,area,num++);
                    results[1] = Math.max(results[1],nowSize);
                    size.add(nowSize);
                    results[0]++;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int dir = 0 ; dir < 4; dir++){
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    if(checkBound(ny,nx,n,m) && area[ny][nx] != area[i][j]){
                        results[2] = Math.max(results[2], size.get(area[ny][nx]-1) + size.get(area[i][j]-1));
                    }
                }
            }
        }
        for(int result : results){
            System.out.println(result);
        }
    }

    private static final int WEST = 0; // 서
    private static final int NORTH = 1; // 북
    private static final int EAST = 2; // 동
    private static final int SOUTH = 3; // 남

    private static final int[] dy = {0, -1, 0, 1};
    private static final int[] dx = {-1, 0, 1, 0};

    private static final int EMPTY = 0;

    private static int bfs(int y, int x, int[][] map, int n, int m, int[][] area, int num) {
        int result = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y, x});
        area[y][x] = num;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];
            for(int dir = 0 ; dir < 4; dir++){
                int isBlock = map[nowY][nowX] & (1 << dir);
                int ny = nowY + dy[dir];
                int nx = nowX + dx[dir];
                if(isBlock == EMPTY && checkBound(ny,nx,n,m) && area[ny][nx] == 0){
                    result++;
                    area[ny][nx] = num;
                    q.offer(new int[] {ny,nx});
                }
            }
        }
        return result;
    }
    private static boolean checkBound(int y, int x, int n, int m){
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
