package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16469 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        int[][][] visited = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            for (int j = 0; j < m; j++) {
                Arrays.fill(visited[i][j], NOT_VALID);
                map[i][j] = stoi.apply(command.charAt(j) + "");
            }
        }
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int y = stoi.apply(st.nextToken()) - 1;
            int x = stoi.apply(st.nextToken()) - 1;
            bfs(y, x, i, map, visited, n, m);
        }
        int min = INF;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean flag = true;
                int max = 0;
                for (int k = 0; k < 3; k++) {
                    if (visited[i][j][k] == NOT_VALID) {
                        flag = false;
                        break;
                    }
                    max = Math.max(max, visited[i][j][k]);
                }
                if (!flag) {
                    continue;
                }
                if (min == max) {
                    cnt++;
                }
                if (min > max) {
                    min = max;
                    cnt = 1;
                }
            }
        }
        if(cnt == 0){
            System.out.println(NOT_FOUND);
            return ;
        }
        System.out.println(min);
        System.out.println(cnt);
    }

    private static final int[] DY = {-1, 0, 1, 0};
    private static final int[] DX = {0, 1, 0, -1};
    private static final int NOT_VALID = -1;
    private static final int NOT_FOUND = -1;
    private static final int INF = 987654321;
    private static final int BLOCK = 1;
    private static final int EMPTY = 0;

    private static void bfs(int y, int x, int type, int[][] map, int[][][] visited, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        int time = 0;
        visited[y][x][type] = time;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < m
                        && visited[ny][nx][type] == NOT_VALID && map[ny][nx] == EMPTY) {
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx][type] = time + 1;
                    }
                }
            }
            time++;
        }
    }
}
