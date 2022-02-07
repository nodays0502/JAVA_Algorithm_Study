package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14938 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] items = new int[n+1];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1 ; i <= n ; i++){
            items[i] = stoi.apply(st.nextToken());
        }

        int[][] map = new int[n+1][n+1];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
        }
        System.out.println(cal(map,items,n,k));
    }

    private static int cal(int[][] map, int[] items, int n, int k) {
        int[][] newMap = floyd(map,n);
        int result = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                System.out.print(newMap[i][j]+" ");
            }
            System.out.println();
        }
        for(int i = 1 ; i <= n ; i++){
            int temp = items[i];
            for(int j = 1 ; j <= n ; j++){
                if(newMap[i][j] != 0 && newMap[i][j] <= k){
                    temp += items[j];
                }
            }
            result = Math.max(result,temp);
        }
        return result;
    }
    private static int[][] floyd(int[][] map, int n) {
        int[][] temp = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                temp[i][j] = map[i][j];
            }
        }
        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if(i == j || i == k || k == j){
                        continue;
                    }
                    if(temp[i][j] != 0 && temp[i][k] != 0 && temp[k][j] != 0){
                        temp[i][j] = Math.min(temp[i][j] , temp[i][k] + temp[k][j]);
                    }else if(temp[i][k] != 0 && temp[k][j] != 0){
                        temp[i][j] = temp[i][k] + temp[k][j];
                    }
                }
            }
        }
        return temp;
    }
}
