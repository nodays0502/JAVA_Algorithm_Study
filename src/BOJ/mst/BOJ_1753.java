package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1753 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<int[]>[] edges = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            edges[i] = new LinkedList<>();
        }
        int k = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[start].add(new int[]{end,weight});
        }
        int[] distance = cal(edges,k,n);
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++){
            if(distance[i] == INF){
                sb.append("INF\n");
            }else{
                sb.append(distance[i]+"\n");
            }
        }
        System.out.println(sb.toString());
    }
    private static final int INF = 987654321;

    private static int[] cal(List<int[]>[] edges, int start,int n) {
        int[] distance = new int[n+1];
        Arrays.fill(distance,INF);
        distance[start] = 0;
        boolean[]visited = new boolean[n+1];
        for(int i = 0 ; i < n ; i++){
            int minValue = INF;
            int minIndex = 0;
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && minValue > distance[j]){
                    minIndex = j;
                    minValue = distance[j];
                }
            }
            visited[minIndex] = true;
            if(minIndex == 0){
                break;
            }
            for(int[] next : edges[minIndex]){
                if(!visited[next[0]] && distance[next[0]] > minValue + next[1]){
                    distance[next[0]] = minValue + next[1];
                }
            }
        }
        return distance;
    }

}
