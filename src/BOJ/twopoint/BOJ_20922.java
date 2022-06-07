package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_20922 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        Map<Integer,Integer> map = new HashMap<>();
        int si = 0;
        int ei = 0;
        int result = 0;
        while(true){
//            System.out.println(si+" "+ei);
            int num = input[ei];
            while(map.getOrDefault(num,0) >= k){
                int prev = input[si++];
                map.merge(prev,0,(v1,v2)->v1-1);
            }
            result = Math.max(result,ei-si+1);
            map.merge(num,1,(v1,v2)-> v1+1);
            ei++;
            if(ei >= n){
                break;
            }

        }
        System.out.println(result);
    }
}
