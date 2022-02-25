package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1561 {
    private static int findLastChildNumber(int[] input,int n,int m,int maxValue){
        if(n <= m){
            return n;
        }
        long min = 0;
        long max = 2_000_000_000L * 30L;
//        System.out.println(max);
        long time = Long.MAX_VALUE;
        while(min <= max){
            long mid = (min + max) / 2;
            long value = calChildInTime(mid,input,m);
            if(value >= n){
                time = Math.min(time,mid);
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        int cnt = 0;
        for(int i = 0 ; i < m ; i++){
            cnt += (time -1) / input[i];
            if((time -1) % input[i] != 0){
                cnt++;
            }
        }
        int result = -1;
        for(int i = 0 ; i < m ; i++){
            if( (time -1) % input[i] == 0){
                cnt++;
                if(cnt == n){
                    result = i + 1;
                    break;
                }
            }
        }
        return result;
    }
    private static long calChildInTime(long time, int[]input, int m){
        long result = 0;
        for(int i = 0 ; i < m ; i++){
            result += time / input[i];
            if(time % input[i] != 0){
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] input= new int[m];
        st = new StringTokenizer(br.readLine()," ");
        int max = 0;
        for(int i = 0 ; i < m ; i++){
            input[i] = stoi.apply(st.nextToken());
            max = Math.max(max,input[i]);
        }
        System.out.println(findLastChildNumber(input,n,m,max));
    }
}
