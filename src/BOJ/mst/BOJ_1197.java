package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1197 {
    private static final int BLOCK = 1_000_001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int v = stoi.apply(st.nextToken());
        int e = stoi.apply(st.nextToken());
        int[][] map = new int[v+1][v+1];
        for(int i = 1 ; i <= v ; i++){
            Arrays.fill(map[i],BLOCK);
        }
        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
        }
        int result = cal(map,v);
        System.out.println(result);
    }

    private static int cal(int[][] map, int n) {
        int result = 0;
        int[] distance = new int[n+1];
        Arrays.fill(distance,BLOCK);
        distance[1] = 0;
        boolean[] visited = new boolean[n+1];
        for(int i = 0 ; i < n ; i++){
            int minValue = BLOCK;
            int minIndex = 0;
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && minValue > distance[j]){
                    minIndex = j;
                    minValue = distance[j];
                }
            }
            visited[minIndex] = true;
            result += minValue;
//            System.out.println(minIndex+" "+minValue+" "+Arrays.toString(distance));
            for(int j = 1; j <= n ; j++){
                if(!visited[j] && distance[j] > map[minIndex][j]){
                    distance[j] = map[minIndex][j];
                }
            }
        }
        return result;
    }
}
