package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1951 {
    private static final int LIMIT = 1234567;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = 0;
        int length = getLength(n);
        while(n >= 10){
            result += (n - Math.pow(10,length-1) + 1) * length;
            n = (int)Math.pow(10,length-1) - 1;
            length--;
        }
        result += n;
        result %= LIMIT;
        System.out.println(result);
    }

    private static int getLength(int n) {
        int length = 0;
        while(n > 0){
            length++;
            n /= 10;
        }
        return length;
    }
}
