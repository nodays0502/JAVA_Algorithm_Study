package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        long result = cal(num, n, m);
        System.out.println(result);
    }

    private static long cal(int[] num, int n, int m) {
        long start = 0;
        long end = 2_000_000_000;
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long temp = check(num, mid, n);
            if (temp >= m) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    private static long check(int[] num, long mid, int n) {
        long sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(num[i] > mid){
                sum += num[i]- mid;
            }
        }
        return sum;
    }

}
