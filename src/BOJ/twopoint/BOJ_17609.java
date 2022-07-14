package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_17609 {
    private static final int PALINDROME = 0; // palindrome
    private static final int PSEUDO_PALINDROME = 1;
    private static final int NORMAL = 2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int testCnt = stoi.apply(br.readLine());
        for(int t = 0 ; t < testCnt ; t++){
            String s = br.readLine();
            int type = checkType(s);
            System.out.println(type);
        }
    }

    private static int checkType(String s) {
        int sIndex = 0;
        int eIndex = s.length()-1;
        if(isPalindrome(s,sIndex,eIndex)){
            return PALINDROME;
        }
        if(isPseudoPalindrome(s,sIndex,eIndex)){
            return PSEUDO_PALINDROME;
        }else{
            return NORMAL;
        }
    }
    private static boolean isPalindrome(String s, int sIndex,int eIndex){
        int halfSize = eIndex - sIndex;
        for(int i = 0 ; i < halfSize ; i++){
            if(s.charAt(sIndex+i) != s.charAt(eIndex-i)){
                return false;
            }
        }
        return true;
    }
    private static boolean isPseudoPalindrome(String s, int sIndex,int eIndex){
        while(sIndex < eIndex){
            if(s.charAt(sIndex) != s.charAt(eIndex)){
                boolean deleteEndIndex = isPalindrome(s,sIndex,eIndex-1);
                boolean deleteStartIndex = isPalindrome(s,sIndex+1,eIndex);
                if(!deleteEndIndex && !deleteStartIndex){
                    return false;
                }else{
                    return true;
                }
            }
            sIndex++;
            eIndex--;
        }
        return true;
    }
}
