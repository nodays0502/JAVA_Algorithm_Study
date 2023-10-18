package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1500 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        long result = 1;
        int cnt = n % k;
        for (int i = 0; i < k; i++) {
            if (cnt > 0) {
                result *= (n / k + 1);
                cnt--;
            }else{
                result *= (n / k);
            }
        }
        System.out.println(result);
    }
}
