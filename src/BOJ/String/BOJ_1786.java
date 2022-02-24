package BOJ.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1786 {
    private static List<Integer> kmp(String textString,String patternString){
        char[] text = textString.toCharArray();
        char[] pattern = patternString.toCharArray();
        int tLength = text.length;
        int pLength = pattern.length;
        int[] fail = new int[pLength];
        int j = 0;
        for(int i = 1; i < pLength ; i++){
            while(j > 0 && pattern[i] != pattern[j]){
                j = fail[j-1];
            }
            if(pattern[i] == pattern[j]){
                fail[i] = ++j;
            }
        }
        j = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < tLength ; i++){
//            System.out.println(i+" "+j);
            while(j > 0 && text[i] != pattern[j]){
                j = fail[j-1];
            }
            if(text[i] == pattern[j]){
                if(j == pLength-1){
                    list.add(i+1 - pLength + 1);
                    j = fail[j];
//                    j = 0;
                }else{
                    j++;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();
        List<Integer> result = kmp(text,pattern);
        System.out.println(result.size());
        for(int index : result){
            System.out.print(index+" ");
        }
    }
}
