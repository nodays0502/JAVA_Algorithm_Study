package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14889_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n  = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        boolean[] isSelected = new boolean[n];
        int result = comb(0,0,map,isSelected,n);
        System.out.println(result);
    }
    private static final int INF = 987654321;
    private static int comb(int depth , int index, int[][] map , boolean[] isSelected,int n){
        if(depth == n/2){
            int diff = cal(isSelected,map,n);
            return diff;
        }
        int result = INF;
        for(int i = index ; i < n ; i++){
            if(isSelected[i]){
                continue;
            }
            isSelected[i] = true;
            result = Math.min(result,comb(depth+1,i+1,map,isSelected,n));
            isSelected[i] = false;
        }
        return result;
    }

    private static int cal(boolean[] isSelected, int[][] map, int n) {
        int[] sum = new int[2];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j || isSelected[i] != isSelected[j]){
                    continue;
                }
                if(isSelected[i]){
                    sum[0] += map[i][j];
                }else{
                    sum[1] += map[i][j];
                }
            }
        }
        return Math.abs(sum[0]-sum[1]);
    }
}
