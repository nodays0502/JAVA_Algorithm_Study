package BOJ.dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2504 {
    static final String open = "([";
    static final String close = ")]";
    static final int[] score = {2,3};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean flag = true;
        int result = 0;
        int num = 1;
        for(int i = 0 ; i < command.length() ; i++){
            char now = command.charAt(i);
            int index = open.indexOf(now);
            if(index >= 0 ){ // 여는 괄호
                stack.push(index);
                num *= score[index];
            }else{ // 닫는 괄호
                if(stack.isEmpty()){
                    flag = false;
                }else{
                    index = close.indexOf(now);
                    int prev = stack.pop();
                    if(index == prev){
                        int value = score[index];
                        char prevChar = command.charAt(i-1);
                        int prevIndex = open.indexOf(prevChar);
                        if(prevIndex >= 0 && prevIndex == index){
                            result += num;
                        }
                        num /= value;
                    }else{
                        flag = false;
                    }
                }
            }
            if(!flag){
                break;
            }
        }
        if(flag && stack.isEmpty()){
            System.out.println(result);
        }else{
            System.out.println(0);
        }
    }
}
