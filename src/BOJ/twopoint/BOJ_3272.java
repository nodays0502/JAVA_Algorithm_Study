package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_3272 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        int targetNumber = Integer.parseInt(br.readLine());
        int result = cal(input,targetNumber,n);
        System.out.println(result);
    }

    private static int cal(int[] input, int targetNumber, int n) {
        Arrays.sort(input);
        int startIndex = 0;
        int endIndex = n-1;
        int cnt = 0;
        while(startIndex < endIndex){
            int sum = input[startIndex] + input[endIndex];
            if(sum == targetNumber){
                startIndex++;
                endIndex--;
                cnt++;
                continue;
            }
            if(sum < targetNumber){
                startIndex++;
                continue;
            }

            if(sum > targetNumber){
                endIndex--;
                continue;
            }
        }
        return cnt;
    }
}
