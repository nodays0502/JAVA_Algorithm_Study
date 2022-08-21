package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_1337 {
    private static final int SIZE = 5;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(br.readLine());
        }
        Arrays.sort(input);
        int result = cal(input,n);
        System.out.println(result);
    }

    private static int cal(int[] input, int n) {
        int si = 0;
        int ei = 0;
        int result = 4;
        while(true){
            if(ei >= n){
                break;
            }
            if(input[ei] - input[si] < SIZE){
                ei++;
                result = Math.min(result, SIZE - (ei - si));
            }else{
                si++;
            }
        }
        return result;
    }

}
