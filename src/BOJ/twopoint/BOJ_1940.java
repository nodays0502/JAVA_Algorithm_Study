package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1940 {
    private static int binarySearch(int[]input, int n, int m){
        int si = 0;
        int ei = n-1;
        int result = 0;
        while(si < ei){
            int sum = input[si] + input[ei];
            if(m == sum){
                result++;
            }
            if(sum <= m){
                si++;
            }
            if(sum >= m){
                ei--;
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int m = stoi.apply(br.readLine());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        Arrays.sort(input);
        System.out.println(binarySearch(input,n,m));
    }
}
