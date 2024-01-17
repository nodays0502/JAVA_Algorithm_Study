package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1343 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        String result = cal(0,command);
        System.out.println(result);
    }
    private static final String NOT_FOUND = "-1";
    private static String cal(int depth, String command) {
        if(depth == command.length()){
            return "";
        }
        if(command.charAt(depth) == '.'){
            String temp = cal(depth+1,command);
            if(temp.equals(NOT_FOUND)){
                return NOT_FOUND;
            }
            return '.'+temp;
        }
        boolean[] can = new boolean[4];
        boolean flag = true;
        for(int i = 0 ; i < 4 && depth + i < command.length(); i++){
            if(command.charAt(depth+i) == '.'){
                flag = false;
            }
            can[i] = flag;
        }
        String result = NOT_FOUND;
        if(can[1]){
            String temp = cal(depth+2,command);
            if(!temp.equals(NOT_FOUND)){
                result = "BB" + temp;
            }
        }
        if(can[3]){
            String temp = cal(depth+4,command);
            if(!temp.equals(NOT_FOUND)){
                result = "AAAA" + temp;
            }
        }
        return result;
    }

}

