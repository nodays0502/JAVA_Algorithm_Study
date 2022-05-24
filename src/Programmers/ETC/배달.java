package Programmers.ETC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배달 {
    private static class Edge{
        int end;
        int weight;
        public Edge(int end,int weight){
            this.end = end;
            this.weight = weight;
        }
    }
    public int solution(int n, int[][] roads, int k) {
        List<Edge>[] edges = new List[n+1];
        for(int i = 1 ; i <= n ; i++){
            edges[i] = new ArrayList<>();
        }
        for(int[] road : roads){
            edges[road[0]].add(new Edge(road[1],road[2]));
            edges[road[1]].add(new Edge(road[0],road[2]));
        }
        int answer = dij(edges,n,k);
        return answer;
        // return 0;
    }
    private static final int INF = 987654321;
    private static int dij(List<Edge>[] edges,int n, int k){
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance,INF);
        distance[1] = 0;
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            int minIndex = 0;
            int minValue = INF;
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && minValue > distance[j]){
                    minValue = distance[j];
                    minIndex = j;
                }
            }
            if(minValue == INF || minValue > k){
                return result;
            }
            visited[minIndex] = true;
            result++;
            for(Edge edge : edges[minIndex]){
                if(!visited[edge.end] && minValue + edge.weight < distance[edge.end]){
                    distance[edge.end] = minValue + edge.weight;
                }
            }
        }
        return result;
    }
}
