package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lope = new int[n];
        for(int i = 0 ; i < n ; i++){ // n
            lope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lope); // nlog(n)
        int maxWeight = 0;
        for(int i = 0 ; i < n ; i++){ // n
            int length = n - i;
            int weight = length * lope[i];
            maxWeight = Math.max(weight,maxWeight);
        }
        System.out.println(maxWeight);
    }
}