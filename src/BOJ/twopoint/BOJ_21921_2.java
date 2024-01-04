package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] visitedCnt = new int[n];
        for(int i = 0 ; i < n ; i++){
            visitedCnt[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = cal(visitedCnt,x,n);
        if(result[0] == 0){
            System.out.println("SAD");
        }else{
            System.out.println(result[0]);
            System.out.println(result[1]);
        }
    }

    private static int[] cal(int[] visitedCnt, int x, int n) {
        int sum = 0;
        int maxSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        int cnt = 0;
        while(true){
            if(endIndex - startIndex < x){
                if(endIndex == n){
                    break;
                }
                sum += visitedCnt[endIndex++];
                continue;
            }
            if(endIndex - startIndex == x){
                if(maxSum < sum){
                    maxSum = sum;
                    cnt = 1;
                }else if(maxSum == sum){
                    cnt++;
                }
                sum -= visitedCnt[startIndex++];
            }
        }
        return new int[]{maxSum, cnt};
    }
}
