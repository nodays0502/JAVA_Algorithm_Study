package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1756 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Long> stol = Long::parseLong;

        long n = stol.apply(st.nextToken());
        long m = stol.apply(st.nextToken());

        Map<Long,Integer> holeCnt = new HashMap<Long,Integer>();
        Map<Long,Integer> usedHole = new HashMap<Long,Integer>();

        long max = 0;
        long prev = 1_000_000_000;
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            long num = stol.apply(st.nextToken());
            prev = Math.min(prev,num);
            holeCnt.merge(prev,1,(v1,v2) -> v1+1);
            if(i == 0){
                max = prev;
            }
        }
        long min = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < m ; i++){
            long num = stol.apply(st.nextToken());
            min = Math.max(num,min);
            min = downPizza(holeCnt,min,max,usedHole);
            if(min == 0){
                break;
            }
        }
        if(min == 0){
            System.out.println(0);
        }else{
            System.out.println(checkDepth(holeCnt,usedHole,max));
        }
    }

    private static long checkDepth(Map<Long,Integer> holeCnt, Map<Long,Integer> usedHole, long max) {
        int result = 1;
        for(long i = max ; i >= 1 ; i--){
            if(usedHole.getOrDefault(i,0) == 0){
                result += holeCnt.getOrDefault(i,0);
            }else {
                result += (holeCnt.get(i) - usedHole.get(i));
                break;
            }
        }
        return result;
    }

    private static long downPizza(Map<Long,Integer> holeCnt,long min,long max, Map<Long,Integer> usedHole) {
        for(long i = min ; i <= max ; i++){
            if(holeCnt.getOrDefault(i,0) > usedHole.getOrDefault(i,0)){
                usedHole.merge(i,1,(v1,v2)-> v1 + 1);
                return i;
            }
        }
        return 0;
    }
}
