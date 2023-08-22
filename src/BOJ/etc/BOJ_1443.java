package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1443 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = stoi.apply(st.nextToken());
        int p = stoi.apply(st.nextToken());
        long limit = 1;
        for(int i = 0 ; i < d; i++){
            limit *= 10;
        }
        Set<String> visited = new HashSet<>();
        long result = cal(0,1,p,limit,visited);
        System.out.println(result);
    }

    private static final int[] NUMBERS = {2,3,4,5,6,7,8,9};
    private static final long NOT_VALID = -1;

    private static long cal(int depth, long now, int p, long limit, Set<String>visited) {
        if(depth == p){
            return now;
        }
        if(now >= limit){
            return NOT_VALID;
        }
        long result = NOT_VALID;
        for(int number : NUMBERS){
            if(now * number < limit){
                if(visited.contains(Arrays.toString((new long[]{depth+1,now*number})))){
                    continue;
                }
                visited.add(Arrays.toString((new long[]{depth+1,now*number})));
                long temp = cal(depth+1,now * number,p,limit,visited);
                result = Math.max(result, temp);
            }else{
                break;
            }
        }
        return result;
    }
}
