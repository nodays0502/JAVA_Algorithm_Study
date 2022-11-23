package Programmers.ETC;

public class 짝수는_싫어요 {
    public int[] solution(int n) {
        int size = (n+1) / 2;
        int[] answer = new int[size];
        for(int i = 0 ; i < size ; i++){
            answer[i] = 2*i + 1;
        }
        return answer;
    }
}
