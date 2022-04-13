package BOJ.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2211 {
    private static final int INF = 987654321;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n+1][n+1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(map[i],INF);
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            map[a][b] = Math.min(c,map[a][b]);
            map[b][a] = Math.min(c,map[b][a]);
        }
        List<int[]> result = dij(map,1,n);
        System.out.println(result.size());
        for(int[] edge : result){
            System.out.println(edge[0]+" "+edge[1]);
        }
    }

    private static List<int[]> dij(int[][] map, int start,int n) {
        List<int[]> result = new LinkedList<>();
        int[] distance = new int[n+1];
        int[] path = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance,INF);
        distance[start] = 0;
        for(int i = 0 ; i < n ; i++){
            int minIndex = 0;
            int minValue = INF;
            for(int j = 1; j <= n ; j++){
                if(!visited[j] && minValue > distance[j]){
                    minValue = distance[j];
                    minIndex = j;
                }
            }
            if(minValue == INF){
                break;
            }
            visited[minIndex] = true;
            if(minIndex != start){
                result.add(new int[] {path[minIndex],minIndex});
            }
            for(int j = 1; j <= n ; j++){
                if(!visited[j] && distance[j] > minValue + map[minIndex][j]){
                    distance[j] = minValue + map[minIndex][j];
                    path[j] = minIndex;
                }
            }
        }
        return result;
    }
}
