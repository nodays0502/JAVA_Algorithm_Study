package Programmers.ETC;

import java.util.Arrays;

public class 등수_매기기 {
    public int[] solution(int[][] scores) {
        int size = scores.length;
        int[] answer = new int[size];
        double[] avgs = new double[size];
        for(int i = 0 ; i < size ; i++){
            int[] score = scores[i];
            double avg = (double)(score[0] + score[1]) / 2;
            avgs[i] = avg;
        }
        Arrays.sort(avgs);
        int value = 1;
        for(int i = size-1 ; i >= 0 ; i--){
            if(i != size-1 && avgs[i + 1] == avgs[i]){
                value++;
                continue;
            }
            for(int j = 0 ; j < size ; j++){
                int[] score = scores[j];
                double avg = (double)(score[0] + score[1]) / 2;
                if(avgs[i] == avg){
                    answer[j] = value;
                }
            }
            value++;
        }
        return answer;
    }
}
