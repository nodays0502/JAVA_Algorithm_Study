package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16401 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int peopleCnt = stoi.apply(st.nextToken());
        int snackCnt = stoi.apply(st.nextToken());
        int[] snack = new int[snackCnt];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < snackCnt ; i++) {
            snack[i] = stoi.apply(st.nextToken());
        }
        int result = binearySearch(snack,peopleCnt);
        System.out.println(result);
    }

    private static int binearySearch(int[] snack, int peopleCnt) {
        int end = 1_000_000_000;
        int start = 0;
        int result = 0;
        while(start <= end){
            int mid = (start+end)/2;
            if(mid == 0){
                break;
            }
            if(checkSnackLengthCnt(snack,mid) >= peopleCnt){
                result = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return result;
    }
    private static int checkSnackLengthCnt(int[]snack, int value){
        int sum = 0;
        for(int length : snack){
            sum += length / value;
        }
        return sum;
    }
}
