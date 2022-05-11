package BOJ.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16916 {
    private static int kmp(String a , String b){
        int tLength = a.length();
        int pLength = b.length();
        char[] text = a.toCharArray();
        char[] pattern = b.toCharArray();

        int[] fail = new int[pLength];
        int j = 0;
        for(int i = 1 ; i < pLength-1 ; i++){
            while(j > 0 && pattern[i] != pattern[j]){
                j = fail[j-1];
            }
            if(pattern[i] == pattern[j]){
                fail[i] = ++j;
            }
        }
        System.out.println(Arrays.toString(fail));
        int result = 0;
        for(int i = 0 ; i < tLength; i++){
            while(j > 0 && text[i] != pattern[j]){
                j = fail[j-1];
            }
            if(text[i] == pattern[j]){
                if(j == pLength-1){
                    result = 1;
                    break;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();
        System.out.println(kmp(text,pattern));
    }
}
