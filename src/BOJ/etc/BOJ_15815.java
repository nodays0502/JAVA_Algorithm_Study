package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_15815 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        Stack<Integer> number = new Stack<>();

        for(int i = 0 ; i < command.length() ; i++){
            char ch = command.charAt(i);
            if(isNumber(ch)){
                number.push(Integer.parseInt(ch+""));
            }else{
                int num2 = number.pop();
                int num1 = number.pop();
                int tempNum = operation(ch,num1,num2);
                number.push(tempNum);
            }
        }
        int result = number.pop();
        System.out.println(result);
    }
    private static int operation(char ch, int num1,int num2){
        if(ch == '*'){
            return num1 * num2;
        }else if(ch == '/'){
            return num1 / num2;
        }else if(ch == '+'){
            return num1 + num2;
        }else if(ch == '-'){
            return num1 - num2;
        }
        return 0;
    }
    private static boolean isNumber(char ch){
        if(ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }
}
