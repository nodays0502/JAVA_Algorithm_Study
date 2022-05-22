package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15810 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        long result = binearySearch(input,n,m);
        System.out.println(result);
    }
    private static final long MIN = 0;
    private static final long MAX = 1_000_000L *  1_000_000L;
    private static long binearySearch(int[] input, int n, int m) {
        long start = MIN;
        long end = MAX;
        long result = MAX;
        while(start <= end){
            long mid = (start + end)/2;
//            System.out.println(mid);
            if(check(input,n,mid,m)){
                result = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean check(int[] input, int n, long time, int m) {
        long cnt = 0;
        for(int i = 0 ; i < n ; i++){
            cnt += time / input[i];
        }
        if(cnt >= m){
            return true;
        }
        return false;
    }
}
