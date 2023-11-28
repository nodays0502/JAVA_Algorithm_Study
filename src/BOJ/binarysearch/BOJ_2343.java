package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] length = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            length[i] = Integer.parseInt(st.nextToken());
        }
        int result = cal(length,n,m);
        System.out.println(result);
    }

    private static int cal(int[] length, int n, int m) {
        int start = 1;
        int end = 10_000 * 100_000;
        int result = end;
        while(start <= end){
            int mid = (start + end)/2;
            if(check(length,mid,n,m)){
                result = Math.min(result,mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean check(int[] length, int num,int n, int m) {
        int sum = 0;
        int cnt = 1;
        for(int i = 0 ; i < n ; i++){
            if(length[i] > num){
                return false;
            }
            sum += length[i];
            if(sum > num){
                cnt++;
                sum = length[i];
            }
        }
        if(cnt > m){
            return false;
        }
        return true;
    }

}
