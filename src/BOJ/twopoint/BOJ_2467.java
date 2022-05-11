package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2467 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        int nearZeroValue = 2_000_000_000;
        int[] result = new int[2];
        int si = 0;
        int ei = n-1;
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        while(true){
            if(si == ei) break;
            int sum = input[si] + input[ei];
            int absSum = Math.abs(sum);
            if(nearZeroValue > absSum){
                nearZeroValue = absSum;
                result[0] = input[si];
                result[1] = input[ei];
            }
            if(sum < 0){ //
                si++;
            }else{
                ei--;
            }
        }
        System.out.printf("%d %d\n",result[0],result[1]);
    }
}
