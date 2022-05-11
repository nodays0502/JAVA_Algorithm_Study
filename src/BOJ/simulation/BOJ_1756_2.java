package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1756_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Long> stol = Long::parseLong;

        long n = stol.apply(st.nextToken());
        long m = stol.apply(st.nextToken());

        List<long[]> hole = new ArrayList<>();
        Map<Integer,Integer> usedHole = new HashMap<Integer,Integer>();

        long prev = 1_000_000_000;
        int cnt = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            long num = stol.apply(st.nextToken());
            if(cnt == 0){
                prev = num;
                cnt++;
                continue;
            }
            if(prev <= num){
                cnt++;
            }else{
                hole.add(new long[] {prev,cnt});
                prev = num;
                cnt = 1;
            }
        }
        hole.add(new long[] {prev,cnt});
//        for(long[] now : hole){
//            System.out.println(Arrays.toString(now));
//        }
        st = new StringTokenizer(br.readLine()," ");
        int index = hole.size()-1;
        for(int i = 0 ; i < m ; i++){
            long num = stol.apply(st.nextToken());
            index = downPizza(hole,index,num,usedHole);
            if(index == -1){
                break;
            }
        }
        if(index == -1){
            System.out.println(0);
        }else{
            System.out.println(checkDepth(hole,usedHole,index));
        }
    }

    private static int checkDepth(List<long[]> hole, Map<Integer, Integer> usedHole, int index) {
        int result = 1;
//        System.out.println(index);
        for(int i = 0 ; i < index ; i++){
            result += hole.get(i)[1];
//            System.out.println(result);
        }
        result += (hole.get(index)[1] - usedHole.get(index));
        return result;
    }

    private static int downPizza( List<long[]> hole,int index,long num, Map<Integer,Integer> usedHole) {
        for(int i = index ; i >= 0 ; i--){
            if(hole.get(i)[0] < num){
                continue;
            }else if(hole.get(i)[1] > usedHole.getOrDefault(i,0)){
                usedHole.merge(i,1,(v1,v2) -> v1 + 1);
                return i;
            }
        }
        return -1;
    }
}
