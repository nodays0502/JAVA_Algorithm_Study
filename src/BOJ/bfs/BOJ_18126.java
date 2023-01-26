package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_18126 {
    private static class Edge{
        int end ;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        List<Edge>[] map = new List[n];
        for(int i = 0 ; i < n ; i++){
            map[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int start = stoi.apply(st.nextToken())-1;
            int end = stoi.apply(st.nextToken())-1;
            int weight = stoi.apply(st.nextToken());
            map[start].add(new Edge(end,weight));
            map[end].add(new Edge(start,weight));
        }
        long result = bfs(map,n);
        System.out.println(result);
    }
    private static final long INF = Long.MAX_VALUE;
    private static long bfs(List<Edge>[] map, int n) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1,o2)->{
            if(o1[1] < o2[1]){
                return -1;
            }else if(o1[1] == o2[1]){
                return 0;
            }else{
                return 1;
            }
        });
        pq.offer(new long[] {0,0});
        long[] distance = new long[n];
        distance[0] = 0;
        Arrays.fill(distance,INF);
        while(!pq.isEmpty()){
            long[] now = pq.poll();
            int position = (int)now[0];
            long weight = now[1];
            for(Edge edge : map[position]){
                int next = edge.end;
                int nextWeight = edge.weight;
                if(distance[next] > weight + nextWeight){
                    distance[next] = weight + nextWeight;
                    pq.offer(new long[]{next,weight + nextWeight});
                }
            }
        }
        long result = 0;
        for(long num : distance){
            if(num == INF){
                continue;
            }
            result = Math.max(result,num);
        }
        return result;
    }
}
