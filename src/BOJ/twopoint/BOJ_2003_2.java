package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] number = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        int result = cal(number,n,m);
        System.out.println(result);
    }

    private static int cal(int[] number, int n, int m) {
        int start = 0;
        int end = 0;
        int cnt = 0;
        int sum = 0;
        while(true){
            if(sum == m){
                cnt++;
            }
            if(sum >= m){
                sum -= number[start++];
            }else{
                if(end >= n){
                    break;
                }
                sum += number[end++];
            }
        }
        return cnt;
    }


}
