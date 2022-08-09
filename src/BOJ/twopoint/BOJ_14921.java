package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14921 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        Arrays.sort(input);
        System.out.println(cal(input,n));
    }
    private static final int TARGET = 0;
    private static final int INF = 987_654_321;
    private static int cal(int[] input, int n) {
        int si = 0;
        int ei = n-1;
        int result = INF;
        while(si < ei){
            int sum = input[si] + input[ei];
            if(Math.abs(sum-TARGET) < Math.abs(result-TARGET)){
                result = sum;
            }
            if(sum > TARGET){
                ei--;
            }else if(sum == TARGET){
                return TARGET;
            }else{
                si++;
            }
        }
        return result;
    }
}
