package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21921 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        cal(input,n,m);
    }
    private static final String NOT_FOUND = "SAD";
    private static void cal(int[] input, int n, int m) {
        int cnt = 0;
        int max = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += input[i];
            if(i >= m){
                sum -= input[i-m];
            }
            if(i >= m-1){
                if(max < sum){
                    max = sum;
                    cnt = 0;
                }
                if(max == sum){
                    cnt++;
                }
            }

        }
        if(max == 0){
            System.out.println(NOT_FOUND);
            return;
        }
        System.out.println(max);
        System.out.println(cnt);
    }
}
