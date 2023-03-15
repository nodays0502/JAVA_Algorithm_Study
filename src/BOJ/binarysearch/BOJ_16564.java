package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16564 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[] level = new int[n];
        for(int i = 0 ; i < n ; i++){
            level[i] = stoi.apply(br.readLine());
        }
        long result = cal(level,n,k);
        System.out.println(result);
    }

    private static long cal(int[] level, int n, int k) {
        long start = 0;
        long end = 2_000_000_000;
        long result = 0;
        while(start <= end){
            long mid = (start+end) / 2;
            if(check(level,n,mid,k)){
                start = mid + 1;
                result = mid;
            }else{
                end = mid - 1;
            }
        }
        return result;
    }

    private static boolean check(int[] level, int n, long mid, int k) {
        long cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(level[i] < mid){
                cnt += mid - level[i];
            }
        }
        if(cnt > k){
            return false;
        }
        return true;
    }
}
