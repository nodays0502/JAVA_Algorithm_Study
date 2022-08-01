package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13334 {

    static class Edge {

        int start;
        int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        List<Edge> edges = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            edges.add(new Edge(Math.min(a, b), Math.max(a, b)));
        }
        int length = stoi.apply(br.readLine());
        edges.sort((o1, o2) -> {
            if(o1.end == o2.end){
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        for(Edge edge : edges){
            while(!pq.isEmpty() && pq.peek() < edge.end - length){
                pq.poll();
            }
            if(edge.start >= edge.end - length){
                pq.offer(edge.start);
            }
            result = Math.max(pq.size(), result);
        }
        System.out.println(result);
    }
}
