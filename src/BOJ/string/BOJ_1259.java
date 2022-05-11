package BOJ.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1259 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        while(!"0".equals(num)){
            int size = num.length();
            boolean flag = true;
            for(int i = 0 ; i < size / 2 ; i++){
                if(num.charAt(0 + i) != num.charAt(size - 1 - i)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
            num = br.readLine();
        }
    }
}
