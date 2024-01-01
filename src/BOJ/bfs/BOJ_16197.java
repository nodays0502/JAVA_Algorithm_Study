package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16197 {
    private static final char COIN = 'o';
    private static final char EMPTY = '.';
    private static final char BLOCK = '#';
    private static final int NOT_FOUND = -1;
    private static final int[] DY = {-1, 0, 1, 0};
    private static final int[] DX = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j + 1] = str.charAt(j);
            }
        }
        int result = bfs(map, n, m);
        System.out.println(result);
    }

    private static int bfs(char[][] map, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        int[] coin = new int[]{-1, -1, -1, -1};
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == COIN) {
                    if (coin[0] != -1) {
                        coin[2] = i;
                        coin[3] = j;
                    } else {
                        coin[0] = i;
                        coin[1] = j;
                    }
                }
            }
        }
        q.offer(coin);
        boolean[][][][] visited = new boolean[n + 2][m + 2][n + 2][m + 2];
        visited[coin[0]][coin[1]][coin[2]][coin[3]] = true;
        visited[coin[2]][coin[3]][coin[0]][coin[1]] = true;
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] now = q.poll();
                boolean[] out = new boolean[2];
                if (now[0] < 1 || now[0] > n || now[1] < 1 || now[1] > m) {
                    out[0] = true;
                }
                if (now[2] < 1 || now[2] > n || now[3] < 1 || now[3] > m) {
                    out[1] = true;
                }
                if (out[0] != out[1]) { // 둘 중 하나 갔다면 바로 결과값 리턴
                    return time;
                }
                if (out[0] || out[1]) { // 둘 중 하나라도 나가면 더 이상 진행X
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int ny1 = now[0] + DY[i];
                    int nx1 = now[1] + DX[i];
                    int ny2 = now[2] + DY[i];
                    int nx2 = now[3] + DX[i];
                    if (map[ny1][nx1] == BLOCK) {
                        ny1 = now[0];
                        nx1 = now[1];
                    }
                    if (map[ny2][nx2] == BLOCK) {
                        ny2 = now[2];
                        nx2 = now[3];
                    }
                    if (!visited[ny1][nx1][ny2][nx2]) {
                        visited[ny1][nx1][ny2][nx2] = true;
                        visited[ny2][nx2][ny1][nx1] = true;
                        q.offer(new int[]{ny1, nx1, ny2, nx2});
                    }
                }
            }
            time++;
            if (time > 10) {
                break;
            }
        }
        return NOT_FOUND;
    }
}
