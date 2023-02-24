package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17266 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int m = stoi.apply(br.readLine());
        int[] input = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        int result = binarySearch(input,m,n);
        System.out.println(result);
    }
    private static final int INF = 987654321;
    private static int binarySearch(int[] input , int m , int n){
        int start = 0;
        int end = INF;
        int result = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            if(cal(input,n,m,mid)){
                end = mid-1;
                result = mid;
            }else{
                start = mid+1;
            }
        }
        return result;
    }

    private static boolean cal(int[] input, int n, int m, int mid) {
        int temp = 0;
        for(int i = 0 ; i < m ; i++){
            if(input[i] - mid <= temp){
                temp = input[i] + mid;
            }else{
                return false;
            }
        }
        if(temp < n){
            return false;
        }
        return true;
    }

}
