package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_9625 {
    static void cal(int n,int[] a, int[] b){
        if(a[n] != -1){
            return ;
        }
        cal(n-1,a,b);
        a[n] = b[n-1];
        b[n] = a[n-1] + b[n-1];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        Arrays.fill(a,-1);
        Arrays.fill(b,-1);
        a[0] = 1;
        a[1] = 0;
        b[0] = 0;
        b[1] = 1;
        cal(n,a,b);
        System.out.println(a[n]+" "+b[n]);
    }
}
