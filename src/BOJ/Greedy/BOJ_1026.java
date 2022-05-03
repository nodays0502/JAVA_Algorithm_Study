package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1026 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] A = new int[n];
        int[] B = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            A[i] = stoi.apply(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            B[i] = stoi.apply(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            result += A[i]*B[n-i-1];
        }
        System.out.println(result);
    }
}
