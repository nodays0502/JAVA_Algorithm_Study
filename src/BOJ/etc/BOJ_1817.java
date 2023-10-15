package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1817 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        if(n == 0){
            System.out.println(0);
            return ;
        }
        int result = 1;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            int temp = stoi.apply(st.nextToken());
            if(sum + temp > m){
                sum = temp;
                result++;
            }else{
                sum += temp;
            }
        }
        System.out.println(result);
    }
}
