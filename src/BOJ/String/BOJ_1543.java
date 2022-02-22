package BOJ.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1543 {
    private static int kmp(String a , String b){
        char[] text = a.toCharArray();
        char[] pattern = b.toCharArray();
        int tLength = text.length;
        int pLength = pattern.length;
        int[] fail = new int[pLength];

        for(int i = 1 , j = 0 ; i < pLength; i++){
            while(j > 0 && pattern[i] != pattern[j]){
                j = fail[j-1];
            }
            if(pattern[i] == pattern[j]){
                fail[i] = ++j;
            }
        }
        int cnt  = 0;
        for(int i = 0 , j = 0 ; i < tLength ; i++){ // i 텍스트 포인트 , j는 패턴 포인터
            while(j > 0 && text[i] != pattern[j]){
                j = fail[j-1];
            }
            if(text[i] == pattern[j]){
                if(j == pLength-1){
                    cnt++;
                    j = 0;
//                    j = fail[j];
                }else{
                    j++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        System.out.println(kmp(a,b));
    }
}
