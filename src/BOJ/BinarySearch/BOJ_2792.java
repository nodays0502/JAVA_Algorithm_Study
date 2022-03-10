package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_2792 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        String[] command = br.readLine().split(" ");
        int n = stoi.apply(command[0]);
        int m = stoi.apply(command[1]);
        int[] input = new int[m];
        for(int i = 0 ; i < m ; i++){
            input[i] = stoi.apply(br.readLine());
        }
        System.out.println(binarySearch(input,n,m));
    }

    private static int binarySearch(int[] input, int n, int m) {
        int result = Integer.MAX_VALUE;
        int max = 1_000_000_000;
        int min = 1;
        while(min <= max){
//            System.out.println(max+" "+min);
            int mid = (max+min)/2;
            int sum = 0;
            for(int i = 0 ; i < m ; i++){
                sum += input[i] / mid;
                if(input[i] % mid != 0){
                    sum++;
                }
            }
            if(sum > n){
                min = mid+1;
            }else{
                max = mid-1;
                result = mid;
            }
        }
        return result;
    }
}
