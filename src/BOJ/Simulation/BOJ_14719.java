package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14719 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] height = new int[m];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < m ; i++){
           height[i] = stoi.apply(st.nextToken());
        }
        int result = 0;
        for(int i = 1 ; i <= n ; i++){
            int index = -1;
            for(int j = 0 ; j < m ; j++){
                if(height[j] >= i){
                    if(index != -1){
                        result += (j - index - 1);
                    }
                    index = j;
                }
            }
//            System.out.println(i+" "+result);
        }
        System.out.println(result);
    }
}
