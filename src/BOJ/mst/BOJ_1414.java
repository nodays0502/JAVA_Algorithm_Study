package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_1414 {
    private static final char EMPTY = '0';
    private static final int a_VALUE = 1;
    private static final int A_VALUE = 27;
    private static final int NOT_CONNECTED = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[][] map = new int[n][n];
        int totalLength = 0;
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < n ; j++){
                char now = command.charAt(j);
                if(Character.isUpperCase(now)){
                    map[i][j] = now - 'A' + A_VALUE;
                }
                if(Character.isLowerCase(now)){
                    map[i][j] = now - 'a' + a_VALUE;
                }
                if(now == EMPTY){
                    map[i][j] = 0;
                }
                totalLength += map[i][j];
            }
        }
        int mstLength = prim(map,n);
        if(mstLength == NOT_CONNECTED){
            System.out.println(NOT_CONNECTED);
            return;
        }
        System.out.println(totalLength - mstLength);
    }
    private static final int INF = 987654321;
    private static int prim(int[][] map, int n) {
        int[] distance = new int[n];
        Arrays.fill(distance,INF);
        boolean[] visited = new boolean[n];
        distance[0] = 0;
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            int minIndex = 0;
            int minValue = INF;
            for(int j = 0 ; j < n ; j++){
                if(!visited[j] && minValue > distance[j]){
                    minIndex = j;
                    minValue = distance[j];
                }
            }
            map = symmetric(map,n);
            if(minValue == INF){
                return NOT_CONNECTED;
            }
            result += minValue;
            visited[minIndex] = true;

            for(int j = 0 ; j < n ; j++){
                if(!visited[j] && map[minIndex][j] != 0 && distance[j] > map[minIndex][j]){
                    distance[j] = map[minIndex][j];
                }
            }
        }
        return result;
    }

    private static int[][] symmetric(int[][] map, int n) {
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] != 0 && map[j][i] != 0){
                    temp[i][j] = Math.min(map[i][j],map[j][i]);
                }else{
                    temp[i][j] = Math.max(map[i][j],map[j][i]);
                }
            }
        }
        return temp;
    }
}
