package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_7490 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        for(int i = 0 ; i < n ; i++){
            int num = stoi.apply(br.readLine());
            cal(2,"1",num);
            resultString.append('\n');
        }
        System.out.println(resultString);
    }
    private static StringBuilder resultString = new StringBuilder();
    private static void cal(int depth, String s, int num) {
        if(depth > num){
            if(isZero(s)){
                resultString.append(s);
                resultString.append('\n');
            }
            return ;
        }
        cal(depth+1,s+" "+depth,num);
        cal(depth+1,s+"+"+depth,num);
        cal(depth+1,s+"-"+depth,num);
    }

    private static boolean isZero(String s) {
        int result = 0;
        int num = 0;
        int temp = 1;
        for(int i = s.length()-1 ; i >= 0 ; i--){
            char ch = s.charAt(i);
            if(isNumber(ch)){
                num += (ch - '0') * temp;
            }
            if( i == 0){
                result += num;
            }
            if(ch == ' '){
                temp *= 10;
            }
            if(ch == '+'){
                temp = 1;
                result += num;
                num = 0;
            }
            if(ch == '-'){
                temp = 1;
                result -= num;
                num = 0;
            }
        }
        if(result == 0){
            return true;
        }
        return false;
    }

    private static boolean isNumber(char ch) {
        if(ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }
}
