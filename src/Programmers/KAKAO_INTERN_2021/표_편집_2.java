package Programmers.KAKAO_INTERN_2021;

import java.util.*;
import java.util.function.Function;
public class 표_편집_2 {

    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char DELETE = 'C';
    private static final char CANCEL = 'Z';

    private static final char VALID = 'O';
    private static final char NOT_VALID = 'X';

    private static final int EMPTY = -1;

    public String solution(int n, int k, String[] cmd) {
        Function<String,Integer> stoi = Integer::parseInt;
        String answer;
        int[] next = new int[n];
        int[] prev = new int[n];
        for(int i = 0 ; i < n ; i++){
            prev[i] = i-1;
            next[i] = i+1;
        }
        next[n-1] = EMPTY;
        prev[0] = EMPTY;
        boolean[] isValid = new boolean[n];
        Arrays.fill(isValid,true);
        LinkedList<Integer> stack = new LinkedList<>();
        int nowPoint = k;

        for(String str : cmd){
            if(str.length() > 1){
                String[] temp = str.split(" ");
                int count = stoi.apply(temp[1]);
                if(str.charAt(0) == UP){
                    for(int i = 0 ; i < count ; i++){
                        nowPoint = move(nowPoint,prev);
                    }
                    continue;
                }
                if(str.charAt(0) == DOWN){
                    for(int i = 0 ; i < count ; i++){
                        nowPoint = move(nowPoint,next);
                    }
                    continue;
                }
            }
            if(str.charAt(0) == DELETE){
                nowPoint = delete(isValid,nowPoint,stack,prev,next);
                continue;
            }
            if(str.charAt(0) == CANCEL){
                cancel(isValid, stack, prev, next);
                continue;
            }
            System.out.println("???");
        }

        StringBuilder sb = new StringBuilder();
        for(boolean valied : isValid){
            if(valied){
                sb.append(VALID);
            }else{
                sb.append(NOT_VALID);
            }
        }
        answer = sb.toString();
        return answer;
    }
    private int move(int now,int[] arr){
        return arr[now];
    }
    private int delete(boolean[] isValid, int now,LinkedList<Integer> stack,
        int[] prev,
        int[] next ){

        stack.offerLast(now);
        isValid[now] = false;
        int prevIndex = move(now,prev);
        int nextIndex = move(now,next);
        if(prevIndex != EMPTY){
            next[prevIndex] = nextIndex;
        }
        if(nextIndex != EMPTY){
            prev[nextIndex] = prevIndex;
        }
        if(nextIndex == EMPTY){
            return prevIndex;
        }
        return nextIndex;
    }
    private void cancel(boolean[] isValid, LinkedList<Integer> stack,
        int[] prev,
        int[] next){
        int index = stack.pollLast();
        isValid[index] = true;
        int prevIndex = move(index,prev);
        int nextIndex = move(index,next);
        if(prevIndex != EMPTY){
            next[prevIndex] = index;
        }
        if(nextIndex != EMPTY){
            prev[nextIndex] = index;
        }
    }
}