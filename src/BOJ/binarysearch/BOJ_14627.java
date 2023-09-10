package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14627 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> stoi = Integer::parseInt;
        int s = stoi.apply(st.nextToken());
        int c = stoi.apply(st.nextToken());
        int[] input = new int[s];
        for (int i = 0; i < s; i++) {
            input[i] = stoi.apply(br.readLine());
        }
        long result = binarySearch(input, c);
        System.out.println(result);
    }
    private static final int MAX = 1_000_000_000;
    private static long binarySearch(int[] input, int c) {
        long start = 1;
        long end = MAX;
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            if(countOnion(mid,input,c)){
                result = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        long sum = 0;
        for(int num : input){
            sum += num;
        }
        return sum - result * c;
    }

    private static boolean countOnion(long mid, int[] input, int c) {
        int cnt = 0;
        for(int num : input){
            cnt += num / mid;
        }
        if(cnt >= c){
            return true;
        }
        return false;
    }
}
