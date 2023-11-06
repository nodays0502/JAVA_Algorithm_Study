package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16234 {
    private static boolean open;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int l = stoi.apply(st.nextToken());
        int r = stoi.apply(st.nextToken());
        int[][] people = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                people[i][j] = stoi.apply(st.nextToken());
            }
        }
        int day = 0;

        while (true) {
            open = false;
            int[][] visited = new int[n][n];
            int number = 1;
            List<Integer> list = new ArrayList<>();
            list.add(0); // dummy
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j] == 0) {
                        int value = bfs(i, j, people, visited, n, r, l,number);
                        list.add(value);
                        number++;
                    }
                }
            }
            if(!open) {
                break;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int nowNum = visited[i][j];
                    people[i][j] = list.get(nowNum);
                }
            }
            day++;
        }
        System.out.println(day);
    }

    private static final int[] DY = {-1, 0, 1, 0};
    private static final int[] DX = {0, 1, 0, -1};

    private static int bfs(int y, int x, int[][] people, int[][] visited, int n,
        int r, int l, int number) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = number;
        int sum = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            sum += people[now[0]][now[1]];
            cnt++;
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n && visited[ny][nx] == 0 &&
                    Math.abs(people[now[0]][now[1]] - people[ny][nx]) <= r &&
                    Math.abs(people[now[0]][now[1]] - people[ny][nx]) >= l) {
                    visited[ny][nx] = number;
                    open = true;
                    q.offer(new int[]{ny, nx});

                }
            }
        }
        return sum/cnt;
    }
}
