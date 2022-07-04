package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_10162 {
    private static final int ONE_MINUTE = 60;
    private static final int[] TIME = {5 * ONE_MINUTE, ONE_MINUTE, 10};
    private static final String NOT_FOUND = "-1";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        String result = cal(n);
        System.out.println(result);
    }
    private static String cal(int money){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 3 ; i++){
            sb.append(money/TIME[i]+" ");
            money %= TIME[i];
        }
        if(money != 0){
            return NOT_FOUND;
        }else{
            return sb.toString();
        }
    }
}
