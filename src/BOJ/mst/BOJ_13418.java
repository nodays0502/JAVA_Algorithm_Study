package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13418 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n+1][n+1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(map[i],-1);
        }
        for(int i = 0 ; i < m + 1 ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            c++;
            c%= 2;
            map[a][b] = c;
            map[b][a] = c;
        }
        int result = (int) (Math.pow(primMax(map,n),2) - Math.pow(primMin(map,n),2));
//        System.out.println(primMax(map,n));
//        System.out.println(primMin(map,n));
        System.out.println(result);
    }

    private static int primMin(int[][] map,int n) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        int result = 0;
        boolean[] visited = new boolean[n+1];
        for(int i = 0 ; i <= n ; i++){
            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 0 ; j <= n ; j++){
                if(!visited[j] && minValue > distance[j]){
                    minIndex = j;
                    minValue = distance[j];
                }
            }
            visited[minIndex] = true;
            if(minValue == Integer.MAX_VALUE){
                break;
            }
            result += minValue;
            for(int j = 0 ; j <= n ; j++){
                if(!visited[j] && map[minIndex][j] != -1 && distance[j] > map[minIndex][j]){
                    distance[j] = map[minIndex][j];
                }
            }
        }
        return result;
    }
    private static int primMax(int[][] map,int n) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[0] = 0;
        int result = 0;
        boolean[] visited = new boolean[n+1];
        for(int i = 0 ; i <= n ; i++){
            int maxValue = -1;
            int maxIndex = 0;
            for(int j = 0 ; j <= n ; j++){
                if(!visited[j] && maxValue < distance[j]){
                    maxIndex = j;
                    maxValue = distance[j];
                }
            }
            visited[maxIndex] = true;
            if(maxValue == -1){
                break;
            }
            result += maxValue;
            for(int j = 0 ; j <= n ; j++){
                if(!visited[j] && map[maxIndex][j] != -1 && distance[j] < map[maxIndex][j]){
                    distance[j] = map[maxIndex][j];
                }
            }
        }
        return result;
    }
}
