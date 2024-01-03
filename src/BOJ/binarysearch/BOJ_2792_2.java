package BOJ.binarysearch;

import javax.sound.sampled.Port;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2792_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] jewelCnt = new int[m];
        for(int i = 0 ; i < m ; i++){
            jewelCnt[i] = Integer.parseInt(br.readLine());
        }
        int result = cal(jewelCnt,n,m);
        System.out.println(result);
    }
    private static final int INF = 1_000_000_000;
    private static int cal(int[] jewelCnt, int n, int m) {
        int start = 1;
        int end = INF;
        int result = 0;
        while(start <= end){
            int mid = (start+end) / 2;
            if(check(mid,jewelCnt,n,m)){
                end = mid - 1;
                result = mid;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean check(int value, int[] jewelCnt, int n, int m) {
        int sum = 0;
        for(int cnt : jewelCnt){
            sum += cnt / value;
            if(cnt % value != 0){
                sum++;
            }
        }
        if(sum <= n){
            return true;
        }else{
            return false;
        }
    }
}
