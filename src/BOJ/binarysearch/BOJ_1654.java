package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {

    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] length = new int[n];
        for(int i = 0 ; i < n ; i++){
            length[i] = Integer.parseInt(br.readLine());
        }
        long result = cal(length,n,k);
        System.out.println(result);
    }

    private static long cal(int[] length, int n, int k) {
        long start = 0;
        long end = Integer.MAX_VALUE;
        long result = 0;
        while(start <= end){
            long mid = (start+end)/2;
            if(check(length,mid,n,k)){
                start = mid + 1;
                result = mid;
            }else{
                end = mid - 1;
            }
        }
        return result;
    }

    private static boolean check(int[] length, long mid, int n, int k) {
        long cnt = 0;
        for(int i = 0 ; i < n ; i++){
            cnt += length[i] / mid;
        }
        if(cnt >= k){
            return true;
        }else{
            return false;
        }
    }
}
