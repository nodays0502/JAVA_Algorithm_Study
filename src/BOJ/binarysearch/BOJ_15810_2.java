package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15810_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] needTime = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            needTime[i] = Integer.parseInt(st.nextToken());
        }
        long result = cal(needTime,n,m);
        System.out.println(result);
    }
    private static final long INF = 1_000_000L * 1_000_000L;
    private static long cal(int[] needTime, int n, int m) {
        long start = 0;
        long end = INF;
        long result = INF;
        while(start <= end){
            long mid = (start + end) / 2;
            if(check(mid,needTime,n,m)){
                result = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean check(long value, int[] needTime, int n, int m) {
        long cnt = 0;
        for(int time : needTime){
            cnt += value / time;
        }
        if(cnt < m){
            return false;
        }else{
            return true;
        }
    }
}
