package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_20366 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        int result = cal(input,n);
        System.out.println(result);
    }
    private static final int INF = 1_000_000_000;
    private static int cal(int[] input, int n) {
        Arrays.sort(input);
        int result = INF;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                int sum1 = input[i] + input[j];
                int start = 0;
                int end = n-1;
                while(start < end){
                    if(start == i || start == j){
                        start++;
                        continue;
                    }
                    if(end == i || end == j){
                        end--;
                        continue;
                    }
                    int sum2 = input[start] + input[end];
                    result = Math.min(Math.abs(sum2-sum1),result);
                    if(sum1 > sum2){
                        start++;
                    }else if(sum1 < sum2){
                        end--;
                    }else{
                        return 0;
                    }
                }

            }
        }
        return result;
    }
}
