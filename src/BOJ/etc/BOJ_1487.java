package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1487 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] price = new int[n];
        int[] deliveryFee = new int[n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            price[i] = stoi.apply(st.nextToken());
            deliveryFee[i] = stoi.apply(st.nextToken());
        }
        int maxValue = 0;
        int maxPrice = 0;
        for(int i = 0 ; i < n ; i++){
            int nowValue = cal(price[i],price,deliveryFee,n);
            if(maxValue < nowValue){
                maxPrice = price[i];
                maxValue = nowValue;
            }
            if(maxValue == nowValue){
                maxPrice = Math.min(maxPrice,price[i]);
            }
        }
        System.out.println(maxPrice);
    }

    private static int cal(int nowPrice, int[] price, int[] deliveryFee, int n) {
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(nowPrice <= price[i] && nowPrice - deliveryFee[i] > 0){
                sum += nowPrice - deliveryFee[i];
            }
        }
        return sum;
    }
}
