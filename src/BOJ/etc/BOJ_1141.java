package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1141 {
    private static final int NOT_FOUND = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for(int i = 0 ; i < n ; i++){
            str[i] = br.readLine();
        }
        int result = 0;
        Arrays.sort(str);
        for(int i = 0 ; i < n ; i++){
            boolean flag = true;
            for(int j = i+1 ;j < n ; j++){
                if(str[j].indexOf(str[i]) == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result++;
            }
        }
        System.out.println(result);
    }

}