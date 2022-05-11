package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_2018 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int result = cal(n);
        System.out.println(result);
    }

    private static int cal(int number) {
        int result = 0;
        int startIndex = 0;
        int endIndex = 0;
        int sum = 0;
        while(endIndex <= number){
            if(sum < number){
                sum += ++endIndex;
                continue;
            }else if(sum == number){
                result++;
                sum -= ++startIndex;
            }else if(sum > number){
                sum -= ++startIndex;
            }
        }
        return result;
    }

}
