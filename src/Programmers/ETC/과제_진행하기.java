package Programmers.ETC;

import java.util.Arrays;
import java.util.Stack;

public class 과제_진행하기 {
    private static class Work{

        String name;
        int workingTime;

        public Work(String name, int workingTime){
            this.name = name;
            this.workingTime = workingTime;
        }
    }
    public String[] solution(String[][] plans) {
        int size = plans.length;
        String[] answer = new String[size];
        Arrays.sort(plans,(o1,o2)->{
            return o1[1].compareTo(o2[1]);
        });
        Stack<Work> stack = new Stack<>();
        int prevTime = 0;
        int answerIndex = 0;
        for(int i = 0 ; i < size ; i++){
            String[] plan = plans[i];
            // System.out.println(Arrays.deepToString(plan));
            String name = plan[0];
            int startTime = stringToTime(plan[1]);
            int workingTime = stringToTime(plan[2]);
            while(!stack.empty()){
                Work prevWork = stack.pop();
                int endTime = prevTime + prevWork.workingTime;
                if(endTime <= startTime){
                    answer[answerIndex++] = prevWork.name;
                    prevTime += prevWork.workingTime;
                }else{
                    stack.push(new Work(prevWork.name, prevWork.workingTime - (startTime - prevTime)));
                    break;
                }
            }
            stack.push(new Work(name,workingTime));
            prevTime = startTime;
        }
        while(!stack.empty()){
            answer[answerIndex++] = stack.pop().name;
        }
        return answer;
    }
    private static int stringToTime(String str){
        String[] temp = str.split(":");
        int result = 0;
        if(temp.length == 2){
            result = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        }else{
            result = Integer.parseInt(str);
        }
        return result;
    }
}
