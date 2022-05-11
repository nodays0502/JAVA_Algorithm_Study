package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_2661_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        String numbers = "";
        System.out.println(dfs(0,numbers,n));
    }
    private static String INF = "9";
    private static String dfs(int depth, String numbers, int n) {
        if(depth == n){
            boolean flag = isGood(numbers,n);
            if(flag){
                return numbers;
            }
            return INF;
        }
        String result = INF;
        for(int i = 1; i <= 3; i++){
            String tempNumbers = numbers+i;
            if(!isGood(tempNumbers,depth+1)){
                continue;
            }
            String temp = dfs(depth + 1,tempNumbers,n);
            if(!INF.equals(temp)){
//                if(result.compareTo(temp) > 0){
//                    result = temp;
//                }
                result = temp;
                break;
            }
        }
        return result;
    }

    private static boolean isGood(String numbers, int n) {
        for(int i = 1 ; i <= numbers.length() / 2 ; i++){
            for(int j = 0 ; j < numbers.length() ; j++){
                if(j+2*i <= n && numbers.substring(j,j+i).equals(numbers.substring(j + i, j + 2*i))){
                    return false;
                }
            }
        }
        return true;
    }
}