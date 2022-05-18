package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_6236 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] money = new int[n];
        for(int i = 0 ; i < n ; i++){
            money[i] = stoi.apply(br.readLine());
        }
        int result = binarySearch(money,n,m);
        System.out.println(result);
    }
    private static final int MIN_MONEY = 1;
    private static final int MAX_MONEY = 10_000 * 100_000;
    private static final int INF = 987654321;
    private static int binarySearch(int[] money, int n, int m) {
        int result = MAX_MONEY;
        int start = MIN_MONEY;
        int end = MAX_MONEY;
        while(start <= end){
            int mid = (start + end) / 2;
            if(checkCnt(money,n,m,mid)){
                result = Math.min(result,mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean checkCnt(int[] money, int n, int m,int withdrawal) {
        int remainder = 0;
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            if(remainder >= money[i]){
                remainder -= money[i];
                continue;
            }
            if(withdrawal >= money[i]){
                result++;
                if(result > m){
                    return false;
                }
                remainder = withdrawal;
                remainder -= money[i];
                continue;
            }
            if(withdrawal < money[i]){
                return false;
            }
        }
        return true;
    }
}
