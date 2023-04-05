package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_5566 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] map = new int[n];
        for(int i = 0 ; i < n ; i++){
            map[i] = stoi.apply(br.readLine());
        }
        int now = 0;
        int result = 0;
        for(int i = 1 ; i <= m ; i++){
            int dice = stoi.apply(br.readLine());
            now += dice;
            if(now >= n-1){
                result = i;
                break;
            }
            now += map[now];
            if(now < 0){
                now = 0;
            }
            if(now >= n-1){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
