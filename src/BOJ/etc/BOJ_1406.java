package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class BOJ_1406 {
    private static final char MOVE_LEFT = 'L';
    private static final char MOVE_RIGHT = 'D';
    private static final char DELETE_LEFT = 'B';
    private static final char APPEND = 'P';
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> left = new LinkedList<>();
        LinkedList<Character> right = new LinkedList<>();
        String str = br.readLine();
        for(int i = 0 ; i < str.length() ; i++){
            left.offerLast(str.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            char type = command.charAt(0);
            if(type == MOVE_LEFT){
                if(!left.isEmpty()){
                    right.offerFirst(left.pollLast());
                }
                continue;
            }
            if(type == MOVE_RIGHT){
                if(!right.isEmpty()){
                    left.offerLast(right.pollFirst());
                }
                continue;
            }
            if(type == DELETE_LEFT){
                if(!left.isEmpty()){
                    left.pollLast();
                }
                continue;
            }
            if(type == APPEND){
                char ch = command.charAt(2);
                left.offerLast(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!right.isEmpty() || !left.isEmpty()){
            if(!left.isEmpty()){
                result.append(left.pollFirst());
                continue;
            }
            if(!right.isEmpty()){
                result.append(right.pollFirst());
                continue;
            }
        }
        System.out.println(result.toString());
    }
}
