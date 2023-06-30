package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_5585 {
    private static final int[] MONEY = {500,100,50,10,5,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int result = cal(1000 - n);
        System.out.println(result);
    }
    private static int cal(int n){
        int result = 0;
        for(int money : MONEY){
            result += n / money;
            n %= money;
        }
        return result;
    }
}
