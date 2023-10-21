package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BOJ_2312 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] input = new int[n];
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(br.readLine());
            max = Math.max(input[i],max);
        }
        List<Integer> prime = findPrime(max);
        for(int i = 0 ; i < n ; i++){
            cal(input[i],prime);
        }
    }

    private static List<Integer> findPrime(int max) {
        List<Integer> result = new ArrayList<>();
        for(int i = 2 ; i <= max ; i++){
            if(isPrime(i)){
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isPrime(int num) {
        for(int i = 2; i < num ; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    private static void cal(int num,List<Integer> prime) {
        int index = 0;
        while(num > 1){
            int nowPrime = prime.get(index);
            int cnt = 0;
            while(num % nowPrime == 0){
                num /= nowPrime;
                cnt++;
            }
            if(cnt != 0){
                System.out.println(nowPrime+" "+cnt);
            }
            index++;
        }
    }
}
