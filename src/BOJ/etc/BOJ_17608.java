package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_17608 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        int max = 0;
        for(int i = n -1 ; i >= 0 ; i--){
            if(max < input[i]){
                cnt++;
                max = input[i];
            }
        }
        System.out.println(cnt);
    }
}
