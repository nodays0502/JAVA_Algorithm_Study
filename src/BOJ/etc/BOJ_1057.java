package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1057 {
    private static final int NOT_FOUND = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int a = stoi.apply(st.nextToken());
        int b = stoi.apply(st.nextToken());
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        int cnt = 1;
        while(a < b){
            if(a+1 == b && b % 2 == 0){
                break;
            }
            a = (a+1)/2;
            b = (b+1)/2;
            cnt++;
        }
        System.out.println(cnt);
    }
}
