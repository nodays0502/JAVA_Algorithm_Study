package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14950 {
    private static class Node{
        int end;
        int weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    private static final int INF = 987654321;
    private static int prim(List<Node>[] map,int n,int t){
        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance,INF);
        distance[1] = 0;
        int result = 0;
        for(int i = 0 ; i < n ; i++){
//            System.out.println(result);
            int minValue = INF;
            int minIndex = 0;
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && minValue > distance[j]){
                    minValue = distance[j];
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            result += minValue;
            if(i > 0){
                result += (i-1) * t;
            }
            for(int j = 0 ; j < map[minIndex].size() ; j++){
                Node next = map[minIndex].get(j);
                if(!visited[next.end] && distance[next.end] > next.weight){
                    distance[next.end] = next.weight;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int t = stoi.apply(st.nextToken());
        List<Node>[] map = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            map[a].add(new Node(b,c));
            map[b].add(new Node(a,c));
        }
        System.out.println(prim(map,n,t));
    }
}
