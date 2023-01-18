package BOJ.twopoint;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_6159 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int s = stoi.apply(st.nextToken());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = stoi.apply(br.readLine());
        }
        Arrays.sort(arr);
        int startIndex = 0;
        int endIndex = n-1;
        int result = 0;
        while(startIndex < endIndex){
            int sum = arr[startIndex] + arr[endIndex];
            if(sum <= s){
                result += endIndex - startIndex;
            }
            if(sum <= s){
                startIndex++;
            }
            if(sum > s){
                endIndex--;
            }
        }
        System.out.println(result);
    }
}
