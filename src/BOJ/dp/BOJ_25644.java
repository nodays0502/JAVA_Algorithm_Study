package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_25644 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] price = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            price[i] = stoi.apply(st.nextToken());
        }
        int result = 0;
        int prev = price[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            if(prev < price[i]){
                prev = price[i];
                continue;
            }
            result = Math.max(result, prev - price[i]);
        }
        System.out.println(result);
    }
}
