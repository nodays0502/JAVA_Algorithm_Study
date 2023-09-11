package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10810 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] buket = new int[n+1];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int start = stoi.apply(st.nextToken());
            int end = stoi.apply(st.nextToken());
            int num = stoi.apply(st.nextToken());
            for(int j = start ; j <= end ; j++){
                buket[j] = num;
            }
        }
        for(int i = 1; i <= n ; i++){
            System.out.print(buket[i]+" ");
        }
    }
}
