package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3190_2 {
    private static final int NO_EDGE = -1;
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<int[]>[] map = new List[n+1];
        for(int i = 1; i <= n ; i++){
            map[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map[a].add(new int[]{b,weight});
            map[b].add(new int[]{a,weight});
        }
        int result = prim(map,n);
        System.out.println(result);
    }
    private static int prim(List<int[]>[] map, int n){
        int[] distance = new int[n+1];
        Arrays.fill(distance,INF);
        distance[1] = 0;
        boolean[] used = new boolean[n+1];
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            int minIndex = 1;
            int minValue = INF;
            for(int j = 1 ; j <= n ; j++){
                if(!used[j] && minValue > distance[j]){
                    minIndex = j;
                    minValue = distance[j];
                }
            }
            used[minIndex] = true;
            result += minValue;
            for(int[] next: map[minIndex]){
                if(used[next[0]]){
                    continue;
                }
                distance[next[0]] = Math.min(distance[next[0]],next[1]);
            }
        }
        return result;
    }

}