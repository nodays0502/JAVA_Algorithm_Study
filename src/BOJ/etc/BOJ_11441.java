package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_11441 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n+1];
        int[] sum = new int[n+1];
        int temp = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1 ; i <= n ; i++){
            input[i] = stoi.apply(st.nextToken());
            temp += input[i];
            sum[i] = temp;
        }
        st = new StringTokenizer(br.readLine()," ");
        int m = stoi.apply(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            System.out.println(sum[b] - sum[a-1]);
        }
    }
}
