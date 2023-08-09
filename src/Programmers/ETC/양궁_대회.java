package Programmers.ETC;

import java.util.Arrays;

public class 양궁_대회 {
    private static final int[] NOT_FOUND = {-1};
    private static final int SIZE = 11;
    private static int[] answer = NOT_FOUND;
    private static int answerGap = 0;
    public int[] solution(int n, int[] info) {
        int[] score = new int[SIZE];
        dfs(0,n,info,score);
        return answer;
    }
    private static void dfs(int depth, int n, int[] info, int[] score){
        if(depth == SIZE){
            int gap = 0;
            if(n > 0){
                score[SIZE-1] += n;
            }
            for(int i = 0 ; i < SIZE ; i++){
                if(info[i] < score[i]){
                    gap += 10 - i;
                }else if(info[i] != 0){
                    gap -= 10 - i;
                }
            }
            if(gap == answerGap && gap != 0){
                for(int i = SIZE - 1 ; i >= 0 ; i--){
                    if(answer[i] < score[i]){
                        answer = Arrays.copyOf(score,SIZE);
                        break;
                    }else if(answer[i] > score[i]){
                        break;
                    }
                }
            }
            if(gap > answerGap){
                answerGap = gap;
                answer = Arrays.copyOf(score,SIZE);
            }
            if(n > 0){
                score[SIZE-1] -= n;
            }
            return ;
        }
        if(n > info[depth]){
            score[depth] = info[depth] + 1;
            dfs(depth+1,n - info[depth] - 1,info,score);
            score[depth] = 0;
        }
        dfs(depth+1,n,info,score);
        return ;
    }
}
