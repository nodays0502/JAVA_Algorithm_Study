package BOJ.Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2630 {
    private static void detectArea(int length, int y, int x, int[][]map,int[] result){
        if(length == 1){
            int color = map[y][x];
            result[color]++;
            return ;
        }
        if(checkAllSameColor(length, y, x, map)){
            int color = map[y][x];
            result[color]++;
            return ;
        }
        int divide = length / 2;
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                detectArea(divide, y + divide * i, x + divide * j, map, result);
            }
        }
    }

    private static boolean checkAllSameColor(int length, int y, int x, int[][] map) {
        int color = map[y][x];
        for(int i = y ; i < y + length ; i++){
            for(int j = x; j < x + length ; j++){
                if(map[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n;  i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int[] result = new int[] {0,0};
        detectArea(n,0,0,map,result);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
