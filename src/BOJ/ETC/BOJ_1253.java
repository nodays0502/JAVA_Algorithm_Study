package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1253 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ;i++){
            input[i] = stoi.apply(st.nextToken());
            map.merge(input[i],1,(o1,o2) -> o1 + 1);
        }
        int result = 0;
        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = n-1 ; j >= 0 ; j--){
                if(i == j){
                    continue;
                }
                int num = input[i] - input[j];
                if(map.containsKey(num)){
                    int cnt = map.get(num);
                    if(input[i] == num){
                        cnt--;
                    }
                    if(input[j] == num){
                        cnt--;
                    }
                    if(cnt > 0){
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
