package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_1789 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Long> stol = Long::parseLong;
        long n = stol.apply(br.readLine());
        long result = 0;
        for(long i = 1 ; i <= n ; i++){
            long temp = (i*(i+1)) / 2;
            if(temp > n){
                result = i-1;
                break;
            }else if(temp == n){
                result= i;
                break;
            }
        }
        System.out.println(result);
    }
}
