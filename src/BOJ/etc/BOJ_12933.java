package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12933 {
    private static final char[] QUACK = {'q','u','a','c','k'};
    private static final int NOT_FOUND = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size = str.length();
        if(str.length() % 5 != 0){
            System.out.println(NOT_FOUND);
            return;
        }
        boolean[] used = new boolean[size];
        int result = 0;
        int quackIndex = 0;
        for(int i = 0 ; i < size ; i++) {
            boolean flag = false;
            for (int j = i; j < size; j++) {
                if(used[j]){
                    continue;
                }
                char ch = str.charAt(j);
                if (QUACK[quackIndex] == ch) {
                    flag = true;
                    used[j] = true;
                    quackIndex++;
                    quackIndex %= 5;
                }
            }
            if(quackIndex != 0) {
                System.out.println(NOT_FOUND);
                return;
            }
            if(flag){
                result++;
            }
        }
        for(int i = 0 ; i < size ; i++){
            if(!used[i]){
                System.out.println(NOT_FOUND);
                return;
            }
        }
        System.out.println(result);
    }
}
