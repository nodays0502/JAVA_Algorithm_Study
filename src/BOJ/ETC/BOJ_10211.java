package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10211 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for(int t = 0 ; t < test ; t++){
            st = new StringTokenizer(br.readLine()," ");
            int n = stoi.apply(st.nextToken());
            int sum = 0;
            int result = -1000;
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0 ; i < n ; i++){
                int num = stoi.apply(st.nextToken());
                sum += num;
                result = Math.max(sum,result);
                sum  = Math.max(sum,0);
            }
            System.out.println(result);
        }
    }
}
