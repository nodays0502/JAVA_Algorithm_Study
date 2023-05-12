package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3986 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0 ; i < n ; i++) {
            String str = br.readLine();
            if (check(str)) {
                result++;
            }
        }
        System.out.println(result);
    }
    private static boolean check(String str){
        int size = str.length();
        if(size % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < size ; i++){
            char ch = str.charAt(i);
            if(stack.isEmpty() || stack.peek() != ch){
                stack.push(ch);
                continue;
            }
            stack.pop();
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
