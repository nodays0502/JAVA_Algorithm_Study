package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_18243 {

    private static final String SMALL = "Small World!";
    private static final String BIG = "Big World!";
    private static final int LIMIT = 6;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        List<Integer>[] list = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new LinkedList<>();
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        String result = SMALL;
        for (int i = 1; i <= n; i++) {
            int length = bfs(i, list, n);
            if (length > LIMIT) {
                result = BIG;
                break;
            }
        }
        System.out.println(result);
    }

    private static int bfs(int start, List<Integer>[] list, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[n + 1];
        int time = -1;
        visited[start] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int now = q.poll();
                for (int next : list[now]) {
                    if (!visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }
            time++;
        }
        for(int i = 1; i <= n ; i++){
            if(!visited[i]){
                return LIMIT+5;
            }
        }
        return time;
    }
}
