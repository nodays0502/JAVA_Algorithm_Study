package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10799 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        int cnt = 0;
        int result = 0;
        char prev = '.';
        for(int i = 0 ; i < command.length() ; i++){
            char now = command.charAt(i);

            if(now == '('){
                cnt++;
            }else{
                cnt--;
                if(prev == ')'){
                    result++;
                }else{
                    result += cnt;
                }
            }
            prev = now;
        }
        System.out.println(result);
    }
}
