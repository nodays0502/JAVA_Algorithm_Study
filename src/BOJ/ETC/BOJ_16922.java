package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class BOJ_16922 {
    private static final int[] KIND = {1,5,10,50};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int num = stoi.apply(br.readLine());
        Set<Integer> visited = new HashSet<>();
        comb(num,0,visited,0);
        int result = visited.size();
        System.out.println(result);
    }

    private static void comb(int count, int start, Set<Integer> visited,int sum) {
        if(count == 0){
            visited.add(sum);
        }
        for(int i = start ; i < KIND.length; i++){
            for(int j = 0 ; j <= count ; j++){
                comb(count - j,i+1,visited,sum + KIND[i] * j);
            }
        }
    }
}
