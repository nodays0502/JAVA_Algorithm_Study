package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1833 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
                if(map[i][j] < 0){
                    result -= map[i][j];
                    map[i][j] = 0;
                }
            }
        }
        result /= 2;
        prim(map,n,result);
    }

    private static final int INF = 987654321;

    private static void prim(int[][] map, int n,int result) {
        int[] distance = new int[n];
        int[] prevIndex = new int[n];
        Arrays.fill(distance,INF);
        distance[0] = 0;
        boolean[] visited = new boolean[n];

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            int minValue = INF;
            int minIndex = 0;
            for(int j = 0 ; j < n ; j++){
                if(!visited[j] && minValue > distance[j]){
                    minValue = distance[j];
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            result += Math.abs(minValue);
            if(i != 0 && minValue > 0){
                cnt++;
                sb.append( (prevIndex[minIndex]+1)+" "+(minIndex+1)+"\n");
            }
            for(int j = 0 ; j < n ; j++){
                if(!visited[j] && distance[j] > map[minIndex][j]){
                    distance[j] = map[minIndex][j];
                    prevIndex[j] = minIndex;
                }
            }
        }
        System.out.println(result+" "+cnt);
        System.out.println(sb.toString());
    }
}
