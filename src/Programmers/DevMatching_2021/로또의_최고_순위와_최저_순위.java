package Programmers.DevMatching_2021;

import java.util.HashSet;
import java.util.Set;

public class 로또의_최고_순위와_최저_순위 {
    private static void init(int[] win_nums,Set<Integer> set){
        for(int num : win_nums){
            set.add(num);
        }
    }
    private static int[] calCorrect(int[] lottos,Set<Integer> numbers){
        int correctCnt = 0;
        int zeroCnt = 0;
        for(int lotto : lottos){
            if(numbers.contains(lotto)){
                correctCnt++;
            }else if(lotto == 0){
                zeroCnt++;
            }
        }
        return new int[] {correctCnt,correctCnt + zeroCnt};
    }
    private static int changeCntToGrade(int correctCnt){
        if(correctCnt == 6){
            return 1;
        }else if(correctCnt == 5){
            return 2;
        }else if(correctCnt == 4){
            return 3;
        }else if(correctCnt == 3){
            return 4;
        }else if(correctCnt == 2){
            return 5;
        }else{
            return 6;
        }
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> numbers = new HashSet<>();
        init(win_nums,numbers);
        int[] result = calCorrect(lottos,numbers);
        answer[0] = changeCntToGrade(result[1]);
        answer[1] = changeCntToGrade(result[0]);
        return answer;
    }
}
