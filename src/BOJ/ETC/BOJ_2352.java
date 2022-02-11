package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2352 {
    private static int lis(int[] input , int n){
        int[] lis = new int[n];
        Arrays.fill(lis,1);
        int result = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(input[i] < input[j] && lis[i] + 1 > lis[j]){
                    lis[j] = lis[i] + 1;
                    result = Math.max(result,lis[j]);
                }
            }
        }
        return result;
    }
    private static int lisBinarySearch(int[] input , int n){
        int[] dp = new int[n];
        int size = 0;
        for(int i = 0 ; i < n ; i++){
            int index = Arrays.binarySearch(dp,0,size,input[i]);
            if(index < 0){
                index = -index - 1;
                dp[index] = input[i];
                if(size < index + 1){
                    size = index + 1;
                }
            }
        }
        return size;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        System.out.println(lisBinarySearch(input,n));
    }
}
