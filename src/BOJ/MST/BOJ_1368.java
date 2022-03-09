package BOJ.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1368 {
    private static final int INF = 987654321;
    private static int cal(int start, int[] input, int[][] map, int n){
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distance,INF);
        int result = input[start];
        distance[start] = 0;
        for(int i = 0 ; i < n ; i++){
            int minIndex = 0;
            int minValue = INF;
            for(int j = 0 ; j < n ; j++){
                if(!visited[j] && distance[j] < minValue){
                    minValue = distance[j];
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            result += minValue;
            for(int j = 0 ; j < n ; j++){
                int nextValue = Math.min(map[minIndex][j],input[j]);
                if(!visited[j] && j != minIndex && distance[j] > nextValue){
                    distance[j] = nextValue;
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
        int[] input = new int[n];
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            input[i] = stoi.apply(st.nextToken());
        }
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = INF;
        for(int i = 0 ; i < n ; i++){
            result = Math.min(result,cal(i,input,map,n));
        }
        System.out.println(result);
    }
}
