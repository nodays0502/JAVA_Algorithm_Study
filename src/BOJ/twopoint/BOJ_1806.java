package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1806 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int s = stoi.apply(st.nextToken());
        int[] number = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            number[i] = stoi.apply(st.nextToken());
        }
        int result = cal(number,n,s);
        System.out.println(result);
    }

    private static final int NOT_FOUND = 0;

    private static int cal(int[] number, int n, int s) {
        int sum = 0;
        int si = 0;
        int ei = 0;
        int result = NOT_FOUND;
        while(true){
            if(sum < s){
                if(ei >= n){
                    break;
                }
                sum += number[ei++];
            }else{
                if(result == NOT_FOUND){
                    result = ei - si;
                }else{
                    result = Math.min(result,ei-si);
                }
                sum -= number[si++];
            }
        }
        return result;
    }
}
