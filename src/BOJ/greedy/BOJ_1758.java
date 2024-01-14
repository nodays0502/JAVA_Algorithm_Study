package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1758 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] tip = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            tip[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tip, Collections.reverseOrder());
        long sum = 0;
        for(int i = 0 ; i < n ; i++){
            int money = Math.max(tip[i]-i,0);
            sum += money;
        }
        System.out.println(sum);
    }
}
