package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15720 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int buggerCnt = stoi.apply(st.nextToken());
        int sideCnt = stoi.apply(st.nextToken());
        int drinkCnt = stoi.apply(st.nextToken());
        int[] bugger = new int[buggerCnt];
        int[] side = new int[sideCnt];
        int[] drink = new int[drinkCnt];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < buggerCnt ; i++){
            bugger[i] = stoi.apply(st.nextToken());

        }
        Arrays.sort(bugger);
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < sideCnt ; i++){
            side[i] = stoi.apply(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < drinkCnt ; i++){
            drink[i] = stoi.apply(st.nextToken());
        }
        Arrays.sort(bugger);
        Arrays.sort(side);
        Arrays.sort(drink);
        int[] result = cal(bugger,side,drink,buggerCnt,sideCnt,drinkCnt);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private static int[] cal(int[] bugger, int[] side, int[] drink, int buggerCnt, int sideCnt, int drinkCnt) {
        int min = Math.min(buggerCnt,sideCnt);
        min = Math.min(min,drinkCnt);
        int sum = 0;
        int saleSum = 0;
        for(int i = buggerCnt-1 ; i >= 0 ; i--){
            sum += bugger[i];
            if(i >= buggerCnt - min){
                saleSum += bugger[i] * 0.9;
            }else{
                saleSum += bugger[i];
            }
        }
        for(int i = sideCnt-1 ; i >= 0 ; i--){
            sum += side[i];
            if(i >= sideCnt - min){
                saleSum += side[i] * 0.9;
            }else{
                saleSum += side[i];
            }
        }
        for(int i = drinkCnt-1 ; i >= 0 ; i--){
            sum += drink[i];
            if(i >= drinkCnt - min){
                saleSum += drink[i] * 0.9;
            }else{
                saleSum += drink[i];
            }
        }
        return new int[]{sum,saleSum};
    }
}
