package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2023_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        cal(0,0,n);
    }
    private static void cal(int depth, int num, int n) {
        if(depth == n){
            System.out.println(num);
            return ;
        }
        for(int i = 0 ; i < 10 ; i++){
            if(depth == 0 && i == 0){
                continue;
            }
            int next = 10*num+i;
            if (isPrime(next)) {
                cal(depth+1,10*num + i,n);
            }
        }
    }
    private static boolean isPrime(int number){
        if(number == 1){
            return false;
        }
        if(number == 2){
            return true;
        }
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

}