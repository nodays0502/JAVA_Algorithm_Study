package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13422 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int testCnt = stoi.apply(st.nextToken());
        for(int t = 0 ; t < testCnt ; t++){
            st = new StringTokenizer(br.readLine());
            int n = stoi.apply(st.nextToken());
            int m = stoi.apply(st.nextToken());
            int k = stoi.apply(st.nextToken());
            int[] input = new int[n+m-1];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                int num = stoi.apply(st.nextToken());
                input[i] = num;
                if(i < m-1 ){
                    input[n+i] = num;
                }
            }
//            System.out.println(Arrays.toString(input));
            int result = cal(input,n,m,k);
            System.out.println(result);
        }
    }

    private static int cal(int[] input, int n, int m, int k) {
        int result = 0;
        int sum = 0;
        for(int i = 0 ; i < n+m-1 ; i++){
            sum += input[i];
            if(i >= m){
                sum -= input[i-m];
            }
            if(i >= m-1 && sum < k){
                result++;
            }
            if(i == m-1 && n == m){
                break;
            }

        }
        return result;
    }
}
