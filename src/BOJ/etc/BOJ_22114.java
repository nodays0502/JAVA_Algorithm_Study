package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22114 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n-1 ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        int result = cal(input,n,k);
        System.out.println(result);
    }

    private static int cal(int[] input, int n, int k) {
        int result = 1;
        int startIndex = 0;
        int endIndex = -1;
        int prevUsedIndex = 0;
        boolean used = false;
        while(true){
            endIndex++;
            if(endIndex == n-1){
                break;
            }
            if(input[endIndex] <= k){

            }else if(!used){
                used = true;
                prevUsedIndex = endIndex + 1;
            }else{
                startIndex = prevUsedIndex;
                prevUsedIndex = endIndex+1;
            }
            result = Math.max(endIndex  - startIndex +2, result);
        }
        return result;
    }
}
