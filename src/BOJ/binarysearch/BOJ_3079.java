package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_3079 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(br.readLine());
        }
        long answer = binarySearch(input,n,m);
        System.out.println(answer);
    }

    private static final long MIN_TIME = 0;
    private static final long MAX_TIME = 1_000_000_000L * 1_000_000_000L;
    private static long binarySearch(int[] input, int n, int m) {
        long result = 0;
        long start = MIN_TIME;
        long end = MAX_TIME;
        while(start <= end){
            long mid = (start + end)/2;
            if(checkInTime(input,n,m,mid)){
                end = mid - 1;
                result = mid;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean checkInTime(int[] input, int n, int m,long time) {
        long peopleCnt = 0;
        for(int i = 0 ; i < n ; i++){
            peopleCnt += (time / input[i]);
        }
        if(peopleCnt >= m){
            return true;
        }
        return false;
    }
}
