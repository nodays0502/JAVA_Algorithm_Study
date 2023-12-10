package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_1914 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n <= 20){
            StringBuilder sb = new StringBuilder();
            int result = cal(n,1,2,3,sb);
            System.out.println(result);
            System.out.println(sb);
        }else{
            BigInteger result = new BigInteger("1");
            for(int i = 0 ; i < n ; i++){
                result = result.multiply(new BigInteger("2"));
            }
            result = result.subtract(new BigInteger("1"));
            System.out.println(result);
        }

    }
    private static int cal(int n, int start, int temp, int end,StringBuilder sb) {
        if(n == 0){
            return 0;
        }
        int result = 1;
        result += cal(n-1,start,end,temp,sb);
        sb.append(start + " " + end + "\n");
        result += cal(n-1,temp,start,end,sb);
        return result;
    }
}
