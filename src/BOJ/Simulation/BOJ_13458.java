package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13458 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int a = stoi.apply(st.nextToken());
        int b = stoi.apply(st.nextToken());
        long result = 0;
        for(int i = 0 ; i < n ; i++){
            input[i] -= a;
            result++;
            if(input[i] > 0){
                result += (input[i] / b);
                if(input[i] % b != 0){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
