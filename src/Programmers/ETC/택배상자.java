package Programmers.ETC;

public class 택배상자 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int size = order.length;
        int index = 0;
        for(int i = 1 ; i <= size ; i++){
            if(order[index] != i){
                stack.push(i);
            }else{
                index++;
                answer++;
            }
            while(!stack.isEmpty() && stack.peek() == order[index]){
                stack.pop();
                index++;
                answer++;
            }
        }
        return answer;
    }
}
