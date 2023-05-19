package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16441 {

    private static final char WOLF = 'W';
    private static final char BLOCK = '#';
    private static final char ICE = '+';
    private static final char EMPTY = '.';
    private static final char SAFE = 'P';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        char[][] result = cal(map, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    private static final int[] DY = {-1, 0, 1, 0};
    private static final int[] DX = {0, 1, 0, -1};

    private static char[][] cal(char[][] map, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        char[][] result = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = map[i][j];
                if(map[i][j] == WOLF){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
//            System.out.println(Arrays.toString(now) + " " + n + " " + m);
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                while (ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] == ICE) {
                    ny += DY[i];
                    nx += DX[i];
                }
                if (ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == BLOCK) {
                    ny -= DY[i];
                    nx -= DX[i];
                }
                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == EMPTY && !visited[i][j]) {
                    result[i][j] = SAFE;
                }
            }
        }
        return result;
    }
}
