package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] number = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        int result = cal(number,n,s);
        System.out.println(result);
    }

    private static int cal(int[] number, int n, int s) {
        int sum = 0;
        int result = 0;
        int startIndex = 0;
        int endIndex = 0;
        while(true){
            if(sum < s){
                if(endIndex >= n){
                    break;
                }
                sum += number[endIndex++];
            }
            while(sum >= s){
                if(result == 0){
                    result = endIndex - startIndex ;
                }
                result = Math.min(result,endIndex - startIndex);
                sum -= number[startIndex++];
            }
        }
        return result;
    }

}