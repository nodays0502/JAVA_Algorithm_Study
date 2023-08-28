package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isTag = false;
        for(int i = 0 ; i < command.length() ; i ++){
            char now = command.charAt(i);
            if(!isTag && now == ' ') {
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(now);
                continue;
            }
            if(now == '<'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                isTag = true;
                sb.append(now);
                continue;
            }
            if(now == '>'){
                StringBuilder temp = new StringBuilder();
                while(!stack.isEmpty()){
                    temp.append(stack.pop());
                }
                sb.append(temp.reverse());
                sb.append(now);
                isTag = false;
                continue;
            }
            stack.push(now);
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);

    }
}
