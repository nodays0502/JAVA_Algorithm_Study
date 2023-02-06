package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_25214 {
    private static final int INF = 1_000_000_009;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n];
        int min = INF;
        int result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
            min = Math.min(min,input[i]);
            result = Math.max(result,input[i] - min);
            System.out.print(result + " ");
        }
    }
}
