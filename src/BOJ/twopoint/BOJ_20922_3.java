package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] number = new int[n];
        for(int i = 0 ; i  < n ; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        int result = cal(number,n,m);
        System.out.println(result);
    }
    private static final int SIZE = 100_000;
    private static int cal(int[] numbers, int n, int m) {
        int[] cnt = new int[SIZE+1];
        int startIndex = 0;
        int endIndex = 0;
        int result = 0;
        while(true){
            if(endIndex >= n){
                break;
            }
            int num = numbers[endIndex++];
            cnt[num]++;
            while(cnt[num] > m){
                cnt[numbers[startIndex++]]--;
            }
            result = Math.max(result,endIndex-startIndex);
        }
        return result;
    }
}
