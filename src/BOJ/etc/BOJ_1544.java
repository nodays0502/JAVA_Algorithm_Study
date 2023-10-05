package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1544 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for(int i = 0 ; i < n ; i++){
            words[i] = br.readLine();
        }
        boolean[] check = new boolean[n];
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            if (check[i]) {
                continue;
            }
            check[i] = true;
            result++;
            for(int j = i+1 ; j < n ; j++){
                if(check[j] || words[i].length() != words[j].length()){
                    continue;
                }
                if(isSame(words[i],words[j])){
                    check[j] = true;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isSame(String word1, String word2) {
        int size = word1.length();
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                int index1 = i;
                int index2 = j;
                boolean isSame = true;
                for(int k = 0 ; k < size ; k++){
                    char ch1 = word1.charAt(index1);
                    char ch2 = word2.charAt(index2);
                    if(ch1 != ch2){
                        isSame = false;
                    }
                    index1++;
                    if(index1 >= size){
                        index1 = 0;
                    }
                    index2++;
                    if(index2 >= size){
                        index2 = 0;
                    }
                }
                if(isSame){
                    return true;
                }
            }
        }
        return false;
    }
}
