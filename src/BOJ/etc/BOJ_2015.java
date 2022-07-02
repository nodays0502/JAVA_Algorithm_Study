package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2015 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        Map<Long,Long> map = new HashMap<>();
        long sum = 0;
        st = new StringTokenizer(br.readLine());
        long result = 0;
        for(int i = 0 ; i < n ; i++){
            long num = stoi.apply(st.nextToken());
            sum += num;
            if(sum == k){
                result++;
            }
            long cnt = map.getOrDefault(sum-k,0L);
            result += cnt;
            map.merge(sum,1L, (v1,v2)->{
                return v1 +1L;
            });
        }
        System.out.println(result);
    }
}
