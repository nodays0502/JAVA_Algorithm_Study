package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14246 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = stoi.apply(st.nextToken());
        }
        int k = stoi.apply(br.readLine());
        int startIndex = 0;
        int endIndex = 0;
        long sum = 0;
        long result = 0;
        while(true){
            if(sum > k){
                result += n - endIndex + 1;
                sum -= arr[startIndex++];
            }else if(endIndex >= n){
                break;
            }else{ // sum < k
                sum += arr[endIndex++];
            }
        }
        System.out.println(result);
    }
}
