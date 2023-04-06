package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_24885 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        long money = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[] price = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            price[i] = stoi.apply(st.nextToken());
        }
        long result = cal(price,n,money,k);
        System.out.println(result);
    }
    private static long cal(int[] price,int n,long money,int k){
        long rent = 0;
        long result = money;
        for(int i = 1 ; i < n ; i++){
            if(price[i-1] < price[i] && price[i-1] <= (k+1) * money){
                rent = money * k;
                long cnt = (money + rent) / price[i-1];
                money += (price[i] - price[i-1]) * cnt;
                continue;
            }
            if(price[i-1] >= price[i] && price[i-1] <= (k+1) * money){
                long temp = (k+1) * money + (price[i] - price[i-1]) * ((k+1) * money/price[i-1]);
                result = Math.max(result,temp);
            }
        }
        money += rent;
        result = Math.max(result,money);
        return result;
    }
}
