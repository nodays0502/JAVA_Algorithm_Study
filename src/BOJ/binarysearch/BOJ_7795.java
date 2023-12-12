package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < testCnt ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aSize = Integer.parseInt(st.nextToken());
            int bSize = Integer.parseInt(st.nextToken());
            int[] a = new int[aSize];
            int[] b = new int[bSize];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < aSize ; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < bSize ; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }
            int result = cal(a,b,aSize,bSize);
            System.out.println(result);
        }
    }

    private static int cal(int[] a, int[] b, int aSize, int bSize) {
        Arrays.sort(a);
        Arrays.sort(b);
        int result = 0;
        for(int i = 0 ; i < aSize ; i++){
            int index = Arrays.binarySearch(b,a[i]);
            if(index < 0){
                index = Math.abs(index) - 1;
            }else{
                for(int j = index -1; j >= 0 ; j--){
                    if(b[index] == b[j]){
                        index = j;
                    }else{
                        break;
                    }
                }
            }
            result += index;
        }
        return result;
    }

}
