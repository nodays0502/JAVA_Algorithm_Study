package BOJ.etc;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_4889 {
    private static final char OPEN = '{';
    private static final char CLOSE = '}';
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        while(true){
            String command = br.readLine();
            if(command.charAt(0) == '-'){
                break;
            }
            int cnt = 0;
            int result = 0;
            for(int i = 0 ; i < command.length() ; i++){
                char ch = command.charAt(i);
                if(ch == OPEN){
                    cnt++;
                }else {
                    cnt--;
                }
                if(cnt < 0){
                    result++;
                    cnt += 2;
                }
            }
            if(cnt > 0){
                result += cnt / 2;
            }
            System.out.println(num + ". " + result);
            num++;
        }
    }
}
