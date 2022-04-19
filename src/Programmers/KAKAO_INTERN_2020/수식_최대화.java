package Programmers.KAKAO_INTERN_2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class 수식_최대화 {
    private static final char[] OPERATION = {'+','-','*'};
    public long solution(String expression) {
        long answer = 0;
        List<Character> oper = new ArrayList<>();
        List<Long> number = new ArrayList<>();
        init(oper, number, expression);
        boolean[] used = new boolean[3];
        answer = dfs(0,used,oper,number);
        return answer;
    }
    private long dfs(int depth, boolean[] used, List<Character> oper, List<Long> number){
        if(depth == 3){
            return Math.abs(number.get(0));
        }
        long result = 0;

        for(int i = 0 ; i < 3; i++){
            if(used[i]){
                continue;
            }
            List<Character> tempOper = new LinkedList<>();
            for(Character ch : oper){
                tempOper.add(ch);
            }
            List<Long> tempNumber = new LinkedList<>();
            for(Long num : number){
                tempNumber.add(num);
            }
            used[i] = true;
            for(int j = 0 ; j < tempOper.size(); j++){
                if(OPERATION[i] == tempOper.get(j)){
                    tempOper.remove(j);
                    long num1 = tempNumber.get(j);
                    long num2 = tempNumber.get(j+1);
                    tempNumber.remove(j+1);
                    tempNumber.remove(j);
                    long temp = 0;
                    if(i == 0){
                        temp = num1 + num2;
                    }else if(i == 1){
                        temp = num1 - num2;
                    }else if(i == 2){
                        temp = num1 * num2;
                    }
                    tempNumber.add(j,temp);
                    j--;
                }
            }
            result = Math.max(result,dfs(depth+1, used, tempOper, tempNumber));
            used[i] = false;
        }
        return result;
    }
    private void init(List<Character> oper, List<Long> number, String expression){
        Function<String,Long> stol = Long::parseLong;
        int si = 0;
        for(int i = 0 ; i < expression.length() ; i++){
            char now = expression.charAt(i);
            if(now < '0' || now > '9'){
                long temp = stol.apply(expression.substring(si,i));
                number.add(temp);
                oper.add(now);
                si = i+1;
            }
        }
        long temp = stol.apply(expression.substring(si,expression.length()));
        number.add(temp);

    }
}
