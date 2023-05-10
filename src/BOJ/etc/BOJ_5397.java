package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.function.Function;

public class BOJ_5397 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            System.out.println(cal(str));
        }
    }
    private static final char LEFT = '<';
    private static final char RIGHT = '>';
    private static final char DELETE = '-';
    private static String cal(String str) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();
        int size = str.length();
        for(int i = 0 ; i < size ; i++){
            char ch = str.charAt(i);
            if(ch == DELETE && !stack.isEmpty()){
                stack.pop();
                continue;
            }
            if(ch == LEFT && !stack.isEmpty()){
                temp.push(stack.pop());
                continue;
            }
            if(ch == RIGHT && !temp.isEmpty()){
                stack.push(temp.pop());
                continue;
            }
            if(ch == DELETE || ch == RIGHT || ch == LEFT){
                continue;
            }
            stack.push(ch);
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
