package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1107 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Set<Integer> isBroken = new HashSet<>();
        if(m != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                isBroken.add(num);
            }
        }
        int result = cal(n, isBroken);
        System.out.println(result);
    }
    private static final int PUSH_BROKEN = -1;
    private static int cal(int n, Set<Integer> isBroken) {
        int result = Math.abs(n - 100);
        for(int i = 0 ; i <= 1_000_000 ; i++){
            int length = check(i,isBroken);
            if(length == PUSH_BROKEN){
                continue;
            }
            result = Math.min(result,length + Math.abs(i-n));
        }
        return result;
    }

    private static int check(int num, Set<Integer> isBroken) {
        if(num == 0 && isBroken.contains(0)){
            return PUSH_BROKEN;
        }
        if(num == 0){
            return 1;
        }
        int cnt = 0;
        while(num > 0){
            if(isBroken.contains(num%10)){
                return PUSH_BROKEN;
            }
            num /= 10;
            cnt++;
        }
        return cnt;
    }

}
