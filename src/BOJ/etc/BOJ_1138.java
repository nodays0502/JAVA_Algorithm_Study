package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;
import org.w3c.dom.ls.LSOutput;

public class BOJ_1138 {
    private static final int EMPTY = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        int[] result = new int[n];
        for(int i = 0 ; i < n ; i++){
            int cnt = input[i];
            int index = 0;
            while(cnt > 0){
                if(result[index] == EMPTY){
                    index++;
                    cnt--;
                    continue;
                }
                while(result[index] != EMPTY){
                    index++;
                }
            }
            while(result[index] != EMPTY){
                index++;
            }
            result[index] = i + 1;
//            System.out.println(Arrays.toString(result));
        }
        for(int i = 0 ; i < n ; i++){
            System.out.print(result[i]+" ");
        }
    }

}
