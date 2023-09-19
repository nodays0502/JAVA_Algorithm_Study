package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1193 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String result = cal(n);
        System.out.println(result);
    }

    private static String cal(int n) {
        int sum = 0;
        int num = 1;
        while(n > sum + num){
            sum += num;
            num++;
        }
        int a = (n - sum); // 분자
        int b =  num + 1 - a; // 분모
//        System.out.println(num+" "+sum);
        String result = a+"/"+b;
        if(num % 2 != 0){
            result = b+"/"+a;
        }
        return result;
    }
}
