package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2217 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] input = new int[n];
        for(int i = 0 ; i < n;  i++){
            input[i] = stoi.apply(br.readLine());
        }
        Arrays.sort(input);
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            result = Math.max(input[i] * (n - i ),result);
        }
        System.out.println(result);
    }
}
