package BOJ.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13905 {
    private static class Edge{
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int start = stoi.apply(st.nextToken());
        int end = stoi.apply(st.nextToken());
        List<Edge>[] list = new ArrayList[n+1];
        for(int i = 0 ; i <= n ; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            list[a].add(new Edge(b,c));
            list[b].add(new Edge(a,c));
        }
        System.out.println(dij(list,start,end,n));
    }
    private static final int INF  = 1_000_000;
    private static int dij(List<Edge>[] list, int start, int end,int n) {
        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance,0);
        distance[start] = INF;
        for(int i = 0 ; i < n ; i++){
            int maxIndex = 0;
            int maxValue = 0;
//            System.out.println(Arrays.toString(distance));
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && maxValue < distance[j]){
                    maxValue = distance[j];
                    maxIndex = j;
                }
            }
            visited[maxIndex] = true;
            if(maxIndex == end){
                return maxValue;
            }
            for(int j = 0 ; j < list[maxIndex].size(); j++){
                Edge edge = list[maxIndex].get(j);
                int next = edge.target;
                int weight = Math.min(edge.weight,maxValue); // Math.min(weight,maxValue)
                if(!visited[next] &&  weight > distance[next]){
                    distance[next] = weight;
                }
            }
        }
        return 0;
    }
}
