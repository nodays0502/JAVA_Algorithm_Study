package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_23351 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int a = stoi.apply(st.nextToken());
        int b = stoi.apply(st.nextToken());
        int period = n/a;
        if(n % a != 0){
            period++;
        }
        int result = cal(k,b,period);
        System.out.println(result);
    }
    private static int cal(int k, int water, int period){
        if(k < period){
            return k;
        }
        int result = 0;
        while(true){
            k -= period;
            if(k < 0){
                return result + period + k;
            }
            k += water;
            result += period;
        }
    }
}
