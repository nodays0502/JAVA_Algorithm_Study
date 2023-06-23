package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2839 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = n / 5;
        int result = -1;
        for(int i = num ; i >= 0 ; i--){
            if((n - 5 * i) % 3 == 0){
                result = i + (n - 5 * i) / 3;
                break;
            }
        }
        System.out.println(result);
    }
}
