package BOJ.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_1062 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        String[] commands = br.readLine().split(" ");
        int n = stoi.apply(commands[0]);
        int k = stoi.apply(commands[1]);
        String[] inputs = new String[n];
        for(int i = 0 ; i < n ; i++) {
            inputs[i] = br.readLine();
        }
        int result = 0;
        if(k < 5){
            System.out.println(result);
        }else{
            boolean[] alpha = new boolean[26];
            alpha['a' - 'a'] = true;
            alpha['n' - 'a'] = true;
            alpha['t' - 'a'] = true;
            alpha['i' - 'a'] = true;
            alpha['c' - 'a'] = true;
            System.out.println(cal(k-5,alpha,0,inputs));
        }
    }

    private static int cal(int depth, boolean[] alpha,int start,String[] inputs) {
        if(depth == 0){
            int count = 0;
            for(String input : inputs){
                boolean flag = true;
                int size = input.length();
                for(int i = 0 ; i < size ; i++){
                    int now = input.charAt(i) - 'a';
                    if(!alpha[now]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    count++;
                }
            }
            return count;
        }else{
            int result = 0;
            for(int i = start ; i < 26 ; i++){
                if(!alpha[i]){
                    alpha[i] = true;
                    result = Math.max(result,cal(depth-1, alpha,i+1,inputs));
                    alpha[i] = false;
                }
            }
            return result;
        }
    }
}
