package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13702 {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = stoi.apply(br.readLine());
        }
        int result = binarySearch(arr,n,k);
        System.out.println(result);
    }
    private static int binarySearch(int[] arr, int n,int k){
        int start = 0;
        int end = INF;
        int result = 0;
        while(start <= end){
            int mid = (int)(((long)end + start) / 2);
            int sum = 0;
            for(int num : arr){
                int div = num / mid;
                sum += div;
            }
            if(sum >= k){
                result = Math.max(result, mid);
                start = mid + 1;
            }else if(sum < k){
                end = mid - 1;
            }
        }
        return result;
    }
}
