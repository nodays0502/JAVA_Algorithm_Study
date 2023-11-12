package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] time = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);
        int sum = 0;
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            sum += time[i];
            result += sum;
        }
        System.out.println(result);
    }

}
