package BOJ.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21924 {
    private static class Node{
        int next;
        int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Node>[] map = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        long sumWeight = 0;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int pointA = stoi.apply(st.nextToken());
            int pointB = stoi.apply(st.nextToken());
            int weight = stoi.apply(st.nextToken());
            sumWeight += weight;
            map[pointA].add(new Node(pointB,weight));
            map[pointB].add(new Node(pointA,weight));
        }
        long mstWeight = primPQ(map,n);
        if(mstWeight == -1){
            System.out.println(-1);
            return ;
        }
        System.out.println(sumWeight - mstWeight);
    }
    private static final int INF = 987654321;
    private static int prim(List<Node>[] map,int n){
        int result = 0;
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance,INF);
        distance[1] = 0;
        for(int i = 0 ; i < n ; i++){
            int minValue = INF;
            int minIndex = 0;
            for(int j = 1; j <= n ; j++){
                if(!visited[j] && distance[j] < minValue){
                    minIndex = j;
                    minValue = distance[j];
                }
            }
            if(minValue == INF){
                return -1;
            }
            result += minValue;
            visited[minIndex] = true;
            for(int j = 0 ; j < map[minIndex].size(); j++){
                Node nextPoint = map[minIndex].get(j);
                if(!visited[nextPoint.next] && distance[nextPoint.next] > nextPoint.weight){
                    distance[nextPoint.next] = nextPoint.weight;
                }
            }
        }
        return result;
    }
    private static long primPQ(List<Node>[] map,int n){
        long result = 0;
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.weight - o2.weight;
        });
        pq.offer(new Node(1,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visited[node.next]){
                continue;
            }
            visited[node.next] = true;
            result += node.weight;
            for(int i = 0 ; i < map[node.next].size() ; i++){
                Node nextPoint = map[node.next].get(i);
                if(visited[nextPoint.next]){
                    continue;
                }
                pq.offer(nextPoint);
            }
        }
        for(int i = 1 ; i <= n ; i++){
            if(!visited[i]){
                return -1;
            }
        }
        return result;
    }
}
