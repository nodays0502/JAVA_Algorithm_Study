package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] number = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        int targetSum = Integer.parseInt(br.readLine());
        long result = calBinarySearch(number,targetSum,n);
        System.out.println(result);
    }
    private static int calFor(int[] number , int targetSum , int n){
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                int sum = number[i] + number[j];
                if(sum == targetSum){
                    result++;
                }
            }
        }
        return result;
    }
    private static int calBinarySearch(int[] number, int targetSum, int n){
        Arrays.sort(number);
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            int targetNumber = targetSum - number[i];
            int index = Arrays.binarySearch(number,i+1,number.length,targetNumber);
            if(index >= 0){
                result++;
            }
        }
        return result;
    }
    private static int calTwoPoint(int[] number, int targetSum, int n){
        Arrays.sort(number);
        int startIndex = 0;
        int endIndex = n-1;
        int result= 0 ;
        while(startIndex < endIndex){
            int sum = number[startIndex] + number[endIndex];
            if(sum == targetSum){
                result++;
                endIndex--;
                continue;
            }
            if(sum < targetSum){
                startIndex++;
                continue;
            }
            if(sum > targetSum){
                endIndex--;
                continue;
            }
        }
        return result;
    }
}
