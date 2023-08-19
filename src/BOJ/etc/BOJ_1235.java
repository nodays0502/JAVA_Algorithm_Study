package BOJ.etc;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1235 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numbers = new String[n];
        for(int i = 0 ; i < n ; i++){
            numbers[i] = br.readLine();
        }
        int answer = numbers[0].length();
        for(int i = 1 ; i < numbers[0].length() ; i++){
            if(check(numbers,i)){
                answer = i;
                 break;
            }
        }
        System.out.println(answer);
    }

    private static boolean check(String[] numbers, int num) {
        Set<String> set = new HashSet<>();
        int size = numbers[0].length();
        for(String str : numbers) {
            String temp = str.substring(size - num,size);
            if(set.contains(temp)){
                return false;
            }
            set.add(temp);
        }
        return true;
    }
}
