package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_4097 {

    private static final long MIN_VALUE = 10_000 * -10;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        while(true){
            int n = stoi.apply(br.readLine());
            if(n == 0){
                break;
            }
            long sum = 0;
            long result = MIN_VALUE;
            for(int i = 0 ; i < n ; i++){
                int num = stoi.apply(br.readLine());
                sum += num;
                result = Math.max(result,sum);
                if(sum < 0){
                    sum = 0;
                }
            }
            System.out.println(result);
        }
    }
}
