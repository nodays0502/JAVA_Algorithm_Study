package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13549 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        int start = stoi.apply(st.nextToken());
        int end = stoi.apply(st.nextToken());
        int result = bfs(start, end);
        System.out.println(result);
    }

    private static final int LIMIT = 2 * 100_000;
    private static final int NOT_FOUND = -1;

    private static int bfs(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        Map<Integer, Integer> visited = new HashMap<>();
        pq.offer(new int[]{start, 0});
        visited.put(start, 0);
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[0] == end) {
                return now[1];
            }
            for (int i = -1; i <= 1; i++) {
                int time = now[1] + 1;
                int next = now[0] + i;
                if (i == 0) {
                    time--;
                    next = 2 * now[0];
                }
                if (next > LIMIT) {
                    continue;
                }
                if (!visited.containsKey(next) || visited.get(next) > time) {
                    visited.put(next, time);
                    pq.offer(new int[]{next, time});
                }
            }

        }
        return NOT_FOUND;
    }
}
