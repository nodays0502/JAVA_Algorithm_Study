package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_3649 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        String command;
        while((command = br.readLine()) != null){
            int width = stoi.apply(command);
            int n = stoi.apply(br.readLine());
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = stoi.apply(br.readLine());
            }
            cal(input, n, width);
        }

    }
    private static final int CM_TO_NANO = 10_000_000;
    private static final String SUCCESS = "yes";
    private static final String FAIL = "danger";
    private static void cal(int[] input, int n, int width) {
        Arrays.sort(input);
        width *= CM_TO_NANO;
        int si = 0;
        int ei = n-1;
        while(si < ei){
            int sum = input[si] + input[ei];
            if(sum > width){
                ei--;
            }else if(sum == width){
                System.out.println(SUCCESS+" "+input[si]+" "+input[ei]);
                return ;
            }else{
                si++;
            }
        }
        System.out.println(FAIL);
    }
}
