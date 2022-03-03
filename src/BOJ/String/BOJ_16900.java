package BOJ.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_16900 {
    private static long kmp(String s){
        char[] text = s.toCharArray();
        int tLength = s.length();
        int[] fail = new int[tLength];
        int j = 0;
        for(int i = 1 ; i < tLength ; i++){
            while(j > 0 && text[i] != text[j]){
                j = fail[j-1];
            }
            if(text[i] == text[j]){
                fail[i] = ++j;
            }
        }
        return fail[tLength-1];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        Function<String,Long> stol = Long::parseLong;
        String s = str[0];
        long k = stol.apply(str[1]);
        long overlap = kmp(s);
        long result = s.length() + (k-1L) * (s.length() - overlap);
        System.out.println(result);
    }
}
