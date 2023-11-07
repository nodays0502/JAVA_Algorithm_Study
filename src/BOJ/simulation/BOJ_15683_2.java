package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683_2 {

    private static final int[][] CCTV_DIR = {
        {}, // DUMMY
        {1}, // 1
        {1, 3}, // 2
        {0, 1}, // 3
        {0, 1, 3}, // 4
        {0, 1, 2, 3} // 5
    };
    private static final int[] DY = {-1, 0, 1, 0};
    private static final int[] DX = {0, 1, 0, -1};
    private static final int EMPTY = 0;
    private static final int BLOCK = 6;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        List<int[]> position = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    position.add(new int[]{i, j});
                }
            }
        }
        int[][] areaCnt = new int[n][m];
        int result = cal(0, map, position, areaCnt, n, m);
        System.out.println(n*m - result);
    }

    private static int cal(int depth, int[][] map, List<int[]> position, int[][] areaCnt, int n, int m) {
        if (depth == position.size()) {
            int result = 0;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(areaCnt[i][j] > 0 || map[i][j] != EMPTY){
                        result++;
                    }
                }
            }
            return result;
        }
        int result = 0;
        int[] now = position.get(depth);
        for (int i = 0; i < 4; i++) {
            int cctvType = map[now[0]][now[1]];
            for (int j = 0; j < CCTV_DIR[cctvType].length; j++) {
                int dir = (CCTV_DIR[cctvType][j] + i) % 4;
                int ny = now[0] + DY[dir];
                int nx = now[1] + DX[dir];
                while (ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] != BLOCK) {
                    areaCnt[ny][nx]++;
                    ny += DY[dir];
                    nx += DX[dir];
                }
            }
            result = Math.max(result,cal(depth+1,map,position,areaCnt,n,m));
            for (int j = 0; j < CCTV_DIR[cctvType].length; j++) {
                int dir = (CCTV_DIR[cctvType][j] + i) % 4;
                int ny = now[0] + DY[dir];
                int nx = now[1] + DX[dir];
                while (ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] != BLOCK) {
                    areaCnt[ny][nx]--;
                    ny += DY[dir];
                    nx += DX[dir];
                }
            }
        }
        return result;
    }
}
