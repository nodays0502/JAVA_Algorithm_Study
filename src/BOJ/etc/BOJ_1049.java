package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1049 {
    private static final int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int setMin = INF;
        int min = INF;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            setMin = Math.min(setMin,a);
            min = Math.min(min,b);
        }
        int result = 0;
        if(6 * min <= setMin){
            result = n * min;
        }else{
            result = Math.min((n/6) * setMin + (n%6) * min, (n/6+1) * setMin);
        }
        System.out.println(result);
    }
}
