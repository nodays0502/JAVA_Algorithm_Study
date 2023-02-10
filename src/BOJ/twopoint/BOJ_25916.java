package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_25916 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        int sp = 0;
        int sum = 0;
        long result = 0;
        for(int i = 0 ; i < n ; i++){
            sum += input[i];
            while(sum > m){
                sum -= input[sp++];
            }
            result = Math.max(result,sum);
        }
        System.out.println(result);
    }
}
