package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1197_4 {
    private static class Edge {
        int start;
        int end;
        int weight;
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();
        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }
        Collections.sort(edges, (v1, v2) -> {
            return v1.weight - v2.weight;
        });
        int result = cal(edges, n, m);
        System.out.println(result);
    }
    private static int findSet(int now, int[] parent) {
        if (now == parent[now]) {
            return now;
        }
        return parent[now] = findSet(parent[now], parent);
    }
    private static boolean union(int a, int b, int[] parent) {
        int aParent = findSet(a, parent);
        int bParent = findSet(b, parent);
        if (aParent == bParent) {
            return false;
        } else {
            parent[aParent] = bParent;
            return true;
        }
    }
    private static int cal(List<Edge> edges, int n, int m) {
        int[] parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int result = 0;
        for (int i = 0; i < m ; i++) {
            Edge edge = edges.get(i);
            if (union(edge.start, edge.end, parent)) {
                result += edge.weight;
            }
        }
        return result;
    }
}