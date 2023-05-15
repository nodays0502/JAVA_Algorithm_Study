package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_2851 {
    private static final int STANDARD = 100;
    private static final int SIZE = 10;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int[] input = new int[SIZE];
        int sum = 0;
        int result = 0;
        for(int i = 0 ; i < SIZE ; i++){
            input[i] = stoi.apply(br.readLine());
            sum += input[i];
            int diff = Math.abs(STANDARD - sum);
            if(diff <= Math.abs(STANDARD - result)){
                result = sum;
            }
        }
        System.out.println(result);

    }
}
