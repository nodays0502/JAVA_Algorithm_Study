package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int result = cal(input, n, w, l);
        System.out.println(result);
    }

    private static int cal(int[] input, int n, int w, int l) {
        Queue<int[]> q = new LinkedList<>(); // int[] {무게,시간}
        int weight = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && weight + input[i] > l) {
                int[] now = q.poll();
                weight -= now[0];
                time = Math.max(time,now[1] + w - 1);
            }
            time++;
            q.offer(new int[]{input[i], time});
            weight += input[i];
        }
        while (!q.isEmpty()) {
            int[] now = q.poll();
            time = now[1] + w;
        }
        return time;
    }
}
