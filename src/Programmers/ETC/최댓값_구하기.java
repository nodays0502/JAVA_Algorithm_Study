package Programmers.ETC;

public class 최댓값_구하기 {
    public int solution(int[] numbers) {
        int answer = Integer.MIN_VALUE;
        int size = numbers.length;
        for(int i = 0  ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(i != j){
                    answer = Math.max(answer,numbers[i] * numbers[j]);
                }
            }
        }
        return answer;
    }
}
