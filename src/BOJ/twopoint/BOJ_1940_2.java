package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1940_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int m = stoi.apply(br.readLine());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }

        System.out.println(binarySearch(input,n,m));
    }

    private static int binarySearch(int[] input, int n, int m) {
        Arrays.sort(input);
        int startIndex = 0;
        int endIndex = n-1;
        int cnt = 0;
        while(startIndex < endIndex){
            int sum = input[startIndex] + input[endIndex];
            if(sum == m){
                cnt++;
                startIndex++;
                endIndex--;
            }
            if(sum < m){
                startIndex++;
            }
            if(sum > m){
                endIndex--;
            }
        }
        return cnt;
    }
}
