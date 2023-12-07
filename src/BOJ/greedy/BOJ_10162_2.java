package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10162_2 {
    private static final int ONE_MINUTE = 60;
    private static final int[] TIME = {5 * ONE_MINUTE, ONE_MINUTE, 10};
    private static final int[] NOT_FOUND = {-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] result = cal(n);
        for(int num: result){
            System.out.print(num + " ");
        }
    }
    private static int[] cal(int money){
        int[] result = new int[3];
        for(int i = 0 ; i < 3 ; i++){
            result[i] = money/TIME[i];
            money %= TIME[i];
        }
        if(money != 0){
            return NOT_FOUND;
        }else{
            return result;
        }
    }
}
