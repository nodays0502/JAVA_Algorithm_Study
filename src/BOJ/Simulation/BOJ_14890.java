package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14890 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (isCanRunway(map, 0, i, n, m, 0, 1, false)) {
//                System.out.println(0 + " " + i + " " + 0);
                result++;
            }
            if (isCanRunway(map, i, 0, n, m, 1, 1, false)) {
//                System.out.println(i + " " + 0 + " " + 1);
                result++;
            }
        }
        System.out.println(result);
    }

    private static final int[] dy = {1, 0};
    private static final int[] dx = {0, 1};

    private static boolean isCanRunway(int[][] map, int y, int x, int n, int m, int dir, int cnt,
        boolean mustBe) {
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
            if (mustBe && cnt < m) {
                return false;
            }
            return true;
        }
        if (mustBe && cnt >= m) {
            cnt = 0;
            mustBe = false;
        }
        int num = map[y][x];
        int next = map[ny][nx];
        if (num == next) {
            return isCanRunway(map, ny, nx, n, m, dir, cnt + 1, mustBe);
        }
        if (num + 1 == next) { // num < next
            if (cnt < m) {
                return false;
            }
            return isCanRunway(map, ny, nx, n, m, dir, 1, false);
        }
        if (num == next + 1) {
            if (mustBe && cnt < m) {
                return false;
            }
            return isCanRunway(map, ny, nx, n, m, dir, 1, true);
        }
        return false;
    }
}
