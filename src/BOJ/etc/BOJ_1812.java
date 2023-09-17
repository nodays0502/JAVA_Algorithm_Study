package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_1812 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] candySum = new int[n];
        for(int i = 0 ; i < n ; i++){
            candySum[i] = stoi.apply(br.readLine());
        }
        int[] candy = new int[n];
        cal(0,candy,candySum,n);
        for(int i = 0 ; i < n ; i++){
            System.out.println(result[i]);
        }
    }
    public static int[] result = null;
    private static void cal(int depth,int[] candy, int[] candySum, int n) {
        if(depth >= n){
            if(candy[0] + candy[n-1] != candySum[n-1]){
                return;
            }
            result = Arrays.copyOf(candy,n);
            return;
        }
        if(depth == 0){
            for(int i = 0 ; i <= candySum[depth] ; i++){
                candy[depth] = i;
                if(candySum[n-1] - i < 0){
                    break;
                }
                candy[n-1] = candySum[n-1] - i;
                cal(depth+1,candy,candySum,n);
            }
        }else{
            int prevIndex = depth - 1;
            if(candySum[prevIndex] - candy[prevIndex] < 0){
                return;
            }
            candy[depth] = candySum[prevIndex] - candy[prevIndex];
            cal(depth+1,candy,candySum,n);
        }
    }
}
