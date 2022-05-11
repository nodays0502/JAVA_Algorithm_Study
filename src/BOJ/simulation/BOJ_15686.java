package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15686 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        List<int[]> shop = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi.apply(st.nextToken());
                if (map[i][j] == 2) {
                    shop.add(new int[]{i, j});
                }
            }
        }
        int result = dfs(m, map, n, shop, 0);
        System.out.println(result);
    }

    private static final int INF = 987654321;

    private static int dfs(int depth, int[][] map, int n, List<int[]> shop, int start) {
        if (depth == 0) {
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        result += bfs(map, n, i, j);
                    }
                }
            }
            return result;
        }
        int result = INF;
        for (int i = start; i < shop.size(); i++) {
            int[] now = shop.get(i);
            map[now[0]][now[1]] = 3;
            result = Math.min(dfs(depth - 1, map, n, shop, i + 1), result);
            map[now[0]][now[1]] = 2;
        }
        return result;
    }

    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    private static int bfs(int[][] map, int n, int y, int x) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        boolean[][] visited = new boolean[n][n];
        visited[y][x] = true;
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] now = q.poll();
                if (map[now[0]][now[1]] == 3) {
                    return time;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
