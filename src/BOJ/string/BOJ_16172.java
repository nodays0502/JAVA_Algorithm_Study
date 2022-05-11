package BOJ.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_16172 {
    private static String deleteNum(String text){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < text.length() ; i++){
            char now = text.charAt(i);
            if( (now >= 'a' && now <= 'z') || (now>='A' && now <= 'Z') ){
                sb.append(now);
            }
        }
        return sb.toString();
    }
    private static int kmp(String textString,String patternString){
        int tLength = textString.length();
        int pLength = patternString.length();
        char[] text = textString.toCharArray();
        char[] pattern = patternString.toCharArray();
        int[] fail = new int[pLength];

        int j = 0 ;
        for(int i = 1 ; i < pLength ; i++){
            while(j > 0 && pattern[i] != pattern[j]){
                j = fail[j-1];
            }
            if(pattern[i] == pattern[j]){
                fail[i] = ++j;
            }
        }
        j = 0;
        for(int i = 0 ; i < tLength ; i++){
            while(j > 0 && text[i] != pattern[j]){
                j = fail[j-1];
            }
            if(text[i] == pattern[j]){
                if(j == pLength-1){
                    return 1;
                }else{
                    j++;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();
        System.out.println(kmp(deleteNum(text),pattern));
    }
}
