package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16398 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long result = cal2(map,n);
        System.out.println(result);
    }
    private static final int INF = 100_000_000 + 1;
    private static long cal(int[][] map , int n){
        int[] distance = new int[n];
        Arrays.fill(distance,INF);
        boolean[] used = new boolean[n];
        distance[0] = 0;
        long result = 0;
        for(int i = 0 ; i < n ; i++){
            int minIndex = 0;
            int minValue = INF;
            for(int j = 0 ; j < n ; j++){
                if(!used[j] && minValue > distance[j]){
                    minIndex = j;
                    minValue = distance[j];
                }
            }
            used[minIndex] = true;
            result += minValue;
            for(int j = 0 ; j < n ; j++){ // v
                if(!used[j] && distance[j] > map[minIndex][j]){
                    distance[j] = map[minIndex][j];
                }
            }
        }
        return result;
    }
    private static long cal2(int[][]map, int n){
        boolean[] used = new boolean[n];
        long result = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2)->{
            return v1[1] - v2[1];
        });
        pq.offer(new int[]{0,0});
        int cnt = 0;
        while(!pq.isEmpty()){ // v
            int[] now = pq.poll(); // log v
            int index = now[0];
            int weight = now[1];
            if(used[index]){
                continue;
            }
            result += weight;
            used[index] = true;
            cnt++;
            if(cnt == n){
                break;
            }
            for (int i = 0; i < n; i++) { // e * log(v)
                if(!used[i]){
                    pq.offer(new int[]{i,map[index][i]});
                }
            }
        }
        return result;
    }
}
