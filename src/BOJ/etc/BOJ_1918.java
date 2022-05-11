package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_1918 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        StringBuilder result = new StringBuilder();
        Deque<Character> operation = new ArrayDeque<>();
        for (int i = 0; i < command.length(); i++) {
            char now = command.charAt(i);
            if (isAlpha(now)) {
                result.append(now);
                continue;
            }
            if(operation.isEmpty() || now == '('){
                operation.offerLast(now);
                continue;
            }
            if(now == '+' || now == '-'){
                while(!operation.isEmpty() && operation.peekLast() != '('){
                    result.append(operation.pollLast());
                }
                operation.offerLast(now);
            }
            if(now == ')'){
                while(!operation.isEmpty() && operation.peekLast() != '('){
                    result.append(operation.pollLast());
                }
                operation.pollLast();
                continue;
            }
            if(now == '*' || now == '/'){
                while(!operation.isEmpty() && (operation.peekLast() == '*' || operation.peekLast() == '/') && operation.peekLast() != '('){
                    result.append(operation.pollLast());
                }
                operation.offerLast(now);
            }
        }
        while (!operation.isEmpty()) {
            result.append(operation.pollLast());
        }
        System.out.println(result.toString());
    }

    private static boolean isAlpha(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        return false;
    }
}
