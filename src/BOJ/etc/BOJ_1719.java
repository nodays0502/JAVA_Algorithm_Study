package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1719 {

    private static final int INF = 987654321;
    private static void floyd(int[][] result ,int[][] map, int size){
        for(int k = 1 ; k <= size ; k++){
            for(int i = 1 ; i <= size ; i++){
                for(int j = 1 ; j <= size ; j++){
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                        result[i][j] = result[i][k];
                    }
                }
            }
        }
    }
    private static void printArr(int[][] arr, int size){
        for(int i = 1 ; i <= size ; i++){
            for(int j = 1; j <= size ; j++){
                if(i == j) {
                    System.out.print("- ");
                }else{
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n+1][n+1];
        int[][] result = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= n ; j++){
                if(i != j){
                    map[i][j] = INF;
                }
            }
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
            result[a][b] = b;
            result[b][a] = a;
        }
        floyd(result ,map, n);
        printArr(result,n);
    }
}
