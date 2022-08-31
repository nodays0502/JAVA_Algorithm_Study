package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_5972 {
    private static class Node{
        int target;
        int weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Node>[] list = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            list[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int start = stoi.apply(st.nextToken());
            int end = stoi.apply(st.nextToken());
            int weight = stoi.apply(st.nextToken());
            list[start].add(new Node(end,weight));
            list[end].add(new Node(start,weight));
        }
        int result = dij2(list,n);
        System.out.println(result);
    }
    private static final int INF = 987654321;
    private static int dij(List<Node>[] list, int n) {
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance,INF);
        distance[1] = 0;
        for(int i = 1 ; i <= n ; i++){
            int minIndex = 0;
            int minValue = INF;
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && minValue > distance[j]){
                    minValue = distance[j];
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            if(minIndex == n){
                return minValue;
            }
            for(Node node : list[minIndex]){
                if(!visited[node.target] && distance[node.target] > node.weight + minValue){
                    distance[node.target] = node.weight + minValue;
                }
            }
        }
        return -1;
    }
    private static int dij2(List<Node>[] list, int n) {
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
        pq.offer(new int[] {1,0});
        for(int i = 1 ; i <= n ; i++){
            int minIndex = 0;
            int minValue = 0;
            while(true){
                int[] now = pq.poll();
                minIndex = now[0];
                minValue = now[1];
                if(!visited[minIndex]){
                    break;
                }
            }
            visited[minIndex] = true;
            if(minIndex == n){
                return minValue;
            }
            for(Node node : list[minIndex]){
                if(!visited[node.target]){
                    pq.offer(new int[] {node.target,node.weight+minValue});
                }
            }
        }
        return -1;
    }
}
