package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2565 {
    private static final int EMPTY = 0;
    private static final int SIZE = 500;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[SIZE+1];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            input[a] = b;
        }
        int[] LIS = new int[SIZE+1];
        int emptyCnt = 0;
        int max = 0;
        Arrays.fill(LIS,1);
        for(int i = 1; i <= SIZE ; i++){
            if(input[i] == EMPTY){
                continue;
            }
            for(int j = i + 1 ; j <= SIZE ; j++){
                if(input[i] < input[j] && LIS[i] + 1 > LIS[j]){
                    LIS[j] = LIS[i] + 1;
                    max = Math.max(LIS[j],max);
                }
            }
        }
        System.out.println(n-max);
    }
}
