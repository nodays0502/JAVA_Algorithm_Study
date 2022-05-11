package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14499 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int y = stoi.apply(st.nextToken());
        int x = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int[] command = new int[k];
        for (int i = 0; i < k; i++) {
            command[i] = stoi.apply(st.nextToken()) - 1;
        }
        move(map, n, m, y, x, command, k);
    }

    private static void move(int[][] map, int n, int m, int y, int x, int[] command, int k) {
        int[][] dice = new int[4][3];
        int ny = y;
        int nx = x;
        for (int i = 0; i < k; i++) {
//            System.out.println(Arrays.deepToString(dice));
            int dir = command[i];
            ny += dy[dir];
            nx += dx[dir];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                ny -= dy[dir];
                nx -= dx[dir];
                continue;
            }
            moveDice(dice,dir);
//            System.out.println(Arrays.deepToString(dice));
            if(map[ny][nx] == 0){
                map[ny][nx] = dice[3][1];
            } else {
                dice[3][1] = map[ny][nx];
                map[ny][nx] = 0;
            }
//            System.out.println(Arrays.deepToString(dice));
            System.out.println(dice[1][1]);
        }
    }

    private static final int dy[] = {0, 0, -1, 1};
    private static final int dx[] = {1, -1, 0, 0};

    private static void moveDice(int[][] dice, int dir) {
//        dir += 4;
//        dir %= 4;
        if (dir == 2 || dir == 3) {
            int y = 0;
            int x = 1;
            int prev = dice[y][x];
            int temp = 0;
            for (int i = 0; i < 4; i++) {
                y += dy[dir];
                if (y >= 4 || y < 0) {
                    y += 4;
                    y %= 4;
                }
                temp = prev;
                prev = dice[y][x];
                dice[y][x] = temp;
            }
        } else {
            int y = 1;
            int x = 0;
            int prev = dice[y][x];
            int temp = 0;
            for (int i = 0; i < 4; i++) {
                x += dx[dir];
                if(y != 1){
                    y = 1;
                    x += dx[(dir + 1) % 2];
                    x += dx[(dir + 1) % 2];
                }else if (x >= 3 || x < 0) {
                    y = 3;
                    x = 1;
                }
                temp = prev;
                prev = dice[y][x];
                dice[y][x] = temp;
            }

        }
    }
}
