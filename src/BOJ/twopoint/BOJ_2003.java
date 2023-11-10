package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int result = cal(num,n,m);
        System.out.println(result);
    }

    private static int cal(int[] num, int n, int m) {
        int startIndex = 0;
        int endIndex = 0;
        int cnt = 0;
        int sum = 0;
        while(true){
            if(sum == m){
                cnt++;
            }
            if(sum >= m){
                sum -= num[startIndex++];
            }else{
                if(endIndex == n){
                    break;
                }
                sum += num[endIndex++];
            }
        }
        return cnt;
    }
}
