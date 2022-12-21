package Programmers.ETC;

public class 연속된_수의_합 {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        for(int i = -1_000 ; i <= 1_000 ; i++){
            int sum = 0;
            for(int j = 0 ; j < num ; j++){
                answer[j] = i+j;
                sum += i + j;
            }
            if(sum == total){
                break;
            }
        }

        return answer;
    }
}
