package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] number = new int[n+1];
        int[] prefixSum = new int[n+1];
        int sum = 0;
        for(int i = 1 ; i <= n ; i++){
            number[i] = Integer.parseInt(st.nextToken());
            sum += number[i];
            prefixSum[i] = sum;
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(prefixSum[end]-prefixSum[start-1]);
        }
    }
}
