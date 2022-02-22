package BOJ.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2902 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] temp = str.split("-");
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < temp.length ; i++){
            sb.append(temp[i].charAt(0));
        }
        System.out.println(sb);
    }
}
