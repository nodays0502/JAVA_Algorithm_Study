package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_18111 {
    private static final int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int b = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        int min = INF;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
                min = Math.min(min,map[i][j]);
                max = Math.max(max,map[i][j]);
            }
        }
        int height = 0;
        int time = INF;
        for(int num = min ; num <= max ; num++) {
            int temp = cal(map,n,m,b,num);
            if(temp == -1){
                continue;
            }
            if(time == temp){
                if(num > height) {
                    height = num;
                }
            }
            if(time > temp){
                time = temp;
                height = num;
            }
        }
        System.out.println(time+" "+height);
    }
    private static int cal(int[][]map , int n, int m , int b, int num){
        int time = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] > num){
                    int temp = map[i][j] - num;
                    b += temp;
                    time += 2 * temp;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] < num){
                    int temp = num - map[i][j];
                    b -= temp;
                    time += temp;
                    if(b < 0){
                        return -1;
                    }
                }
            }
        }
        return time;
    }
}
