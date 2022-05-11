package BOJ.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1701 {

    private static int kmp(String textString) {
        char[] text = textString.toCharArray();
        int tLength = text.length;
        int result = 0;
        int[] fail = new int[tLength];
        int j = 0;
        for (int i =  1; i < tLength; i++) {
            while (j > 0 && text[i] != text[j]) {
                j = fail[j - 1];
            }
            if (text[i] == text[j]) {
                fail[i] = ++j;
                result = Math.max(result, j);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        int result = 0;
        for(int i = 0 ; i < text.length() ; i++){
            String subStr = text.substring(i);
            result = Math.max(result,kmp(subStr));
        }
        System.out.println(result);
    }
}
