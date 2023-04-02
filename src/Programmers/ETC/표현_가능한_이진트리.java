package Programmers.ETC;

public class 표현_가능한_이진트리 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++){
            String str = numToBinary(numbers[i]);
            if(checkBinaryTree(0,str.length()-1,str) == FAIL){
                answer[i] = 0;
            }else{
                answer[i] = 1;
            }
        }
        return answer;
    }
    private static final char FAIL = '6';
    private char checkBinaryTree(int start, int end, String str){
        if(start == end){
            return str.charAt(start);
        }
        int mid = (start + end) / 2;
        char prev = checkBinaryTree(start,mid-1,str);
        char next = checkBinaryTree(mid+1,end,str);
        if(prev == FAIL || next == FAIL){
            return FAIL;
        }
        char now = str.charAt(mid);
        if(now == '0' && (prev == '1' || next == '1')){
            return FAIL;
        }
        return now;
    }
    private String numToBinary(long num){
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            if(num % 2 != 0){
                sb.append(1);
            }else{
                sb.append(0);
            }
            num /= 2;
        }
        calLength(sb);
        sb.reverse();
        return sb.toString();
    }
    private void calLength(StringBuilder sb){
        long size = sb.length();
        long num = 1;
        while(num < size){
            num *= 2;
            num++;
        }
        long diff = num - size;
        while(diff > 0){
            sb.append(0);
            diff--;
        }
    }
}
