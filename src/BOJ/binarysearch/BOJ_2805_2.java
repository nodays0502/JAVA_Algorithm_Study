package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int targetSum = Integer.parseInt(st.nextToken());
        int[] treeHeight = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            treeHeight[i] = Integer.parseInt(st.nextToken());
        }
//        int result = cal(treeHeight,n,targetSum);
        int result = calBinarySearch(treeHeight,n,targetSum);
        System.out.println(result);
    }
    private static final int MAX = 1_000_000_000;
    private static int cal(int[] treeHeight, int n, int targetSum) {
        int result = 0;
        for(int i = 0 ; i <= MAX  ; i++){
            if(check(i,treeHeight,n,targetSum)){
                result = Math.max(result,i);
            }
        }
        return result;
    }
    private static int calBinarySearch(int[] treeHeight,int n , int targetSum){
        int result = 0;
        int start = 0;
        int end = MAX;
        while(start <= end){
            int mid = (start+end)/2;
            if(check(mid,treeHeight,n,targetSum)){
                start = mid + 1;
                result = mid;
            }else{
                end = mid - 1;
            }
        }
        return result;
    }
    private static boolean check(int height, int[] treeHeights, int n,  int targetSum){
        long sum = 0;
        for(int treeHeight : treeHeights){
            sum += Math.max(treeHeight-height,0);
        }
        if(sum >= targetSum){
            return true;
        }else{
            return false;
        }
    }
}
