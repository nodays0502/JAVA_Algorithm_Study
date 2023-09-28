package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1475 {
    private static final int SIZE = 10;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] cnt = new int[SIZE];
        while(num > 0){
            cnt[num % 10]++;
            num /= 10;
        }
        int max = 0;
        for(int i = 0 ; i < SIZE ; i++){
            if(i == 6 || i == 9){
                continue;
            }
            max = Math.max(max,cnt[i]);
        }
        int sixNineCnt = (cnt[6] + cnt[9]) / 2;
        if((cnt[6] + cnt[9]) % 2 != 0){
            sixNineCnt++;
        }
        max = Math.max(max, sixNineCnt);
        System.out.println(max);
    }

}
