package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {

    private static final int NOT_FOUND = -1;
    private static final String EMPTY = "FRULA";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bombStr = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            stack.add(ch);
            if(stack.size() >= bombStr.length()){
                boolean flag = true;
                for(int j = 0 ; j < bombStr.length() ; j++){
                    if(stack.get(stack.size() - bombStr.length() + j) != bombStr.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(!flag) {
                    continue;
                }
                for(int j = 0 ; j < bombStr.length() ; j++){
                    stack.pop();
                }
            }
        }
        if(stack.size() == 0) {
            System.out.println(EMPTY);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        System.out.println(sb.toString());
    }
}
