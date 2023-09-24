package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1052 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        String str = Integer.toBinaryString(n);
        int result = cal(str,k);
        System.out.println(result);
    }

    private static int cal(String str, int k) {
        int oneCnt = countOne(str);
        int result = 0;
        int index = str.length()-1;
        int num = 1;
        StringBuilder sb = new StringBuilder(str);
        while(oneCnt > k && index > 0){
            char ch = sb.charAt(index);
            if(ch != ONE){
                num *= 2;
                index--;
                continue;
            }
            result += num;
            while(ch == ONE && index > 0){
                sb.setCharAt(index,'0');
                oneCnt--;
                index--;
                ch = sb.charAt(index);
                num *= 2;
            }
            sb.setCharAt(index,ONE);
//            System.out.println(sb+" "+index+" "+result);
            oneCnt++;
        }
        return result;
    }
    private static final char ONE = '1';
    private static int countOne(String str) {
        int cnt = 0;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == ONE){
                cnt++;
            }
        }
        return cnt;
    }
}
