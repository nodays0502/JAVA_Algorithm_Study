package BOJ.binarysearch;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] price = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            price[i] = Integer.parseInt(st.nextToken());
            max = Math.max(price[i],max);
        }
        int m = Integer.parseInt(br.readLine());
        int result = cal(price,max,m);
        System.out.println(result);
    }

    private static int cal(int[] price,int max ,int m) {
        int start = 1;
        int end = max;
        int result = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            if(checkPrice(price,mid,m)){
                result = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return result;
    }

    private static boolean checkPrice(int[] price, int mid,int m) {
        int sum = 0;
        for(int num : price){
            sum += Math.min(num,mid);
        }
        if(sum <= m){
            return true;
        }else{
            return false;
        }
    }
}
