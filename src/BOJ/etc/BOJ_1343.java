package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1343 {
    private static final String NOT_FOUND = "-1";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        String result = cal(0,command,"");
        System.out.println(result);
    }

    private static String cal(int depth, String command, String now) {
        if(command.length() <= depth){
            return now;
        }
        if(command.charAt(depth)  == '.'){
            return cal(depth+1,command,now+".");
        }
        String result = NOT_FOUND;
        boolean[] isX = new boolean[4];
        Arrays.fill(isX,true);
        boolean flag = true;
        for(int i = 0 ; i < 4; i++){
            if(depth+i >= command.length()){
                break;
            }
            char ch = command.charAt(depth+i);
            if(ch == '.'){
                flag = false;
            }
            isX[i] = flag;
        }
        if(isX[1] && depth+1 < command.length()){
            String temp = cal(depth+2,command,now+"BB");
            if(result.equals(NOT_FOUND)){
                result = temp;
            }else if(result.compareTo(temp) > 0){
                result = temp;
            }

        }
        if(isX[3] && depth+3 < command.length()){
            String temp = cal(depth+4,command,now+"AAAA");
            if(result.equals(NOT_FOUND)){
                result = temp;
            }else if(result.compareTo(temp) > 0){
                result = temp;
            }
        }
        return result;
    }
}
