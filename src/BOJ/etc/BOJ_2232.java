package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_2232 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] number = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            number[i] = stoi.apply(br.readLine());
        }
        if(n == 1){
            System.out.println(1);
            return ;
        }
        if(number[1] >= number[2]){
            System.out.println(1);
        }
        for(int i = 2 ; i <= n-1 ; i++){
            if(number[i-1] <= number[i] && number[i] >= number[i+1]){
                System.out.println(i);
            }
        }
        if(number[n] >= number[n-1]){
            System.out.println(n);
        }
    }
}
