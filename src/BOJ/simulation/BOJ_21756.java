package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_21756 {
    private static final int EMPTY = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        Arrays.fill(arr,EMPTY);
        for(int i = 1 ; i <= n ; i++){
            arr[i] = i;
        }
        while(!isOne(arr,n)){
            deleteOdd(arr,n);
            shiftLeft(arr,n);
        }
        System.out.println(arr[1]);
    }

    private static void shiftLeft(int[] arr, int n) {
        int index = 1;
        for(int i = 1 ; i <= n ; i++){
            if(arr[i] != EMPTY){
                arr[index] = arr[i];
                arr[i] = EMPTY;
                index++;
            }
        }
    }

    private static void deleteOdd(int[] arr, int n) {
        for(int i = 1 ; i <= n ; i++){
            if(i % 2 != 0){
                arr[i] = EMPTY;
            }
        }
    }

    private static boolean isOne(int[] arr, int n) {
        int cnt = 0;
        for(int i = 1 ; i <= n ; i++){
            if(arr[i] != EMPTY){
                cnt++;
            }
        }
        if(cnt > 1){
            return false;
        }else{
            return true;
        }
    }
}
