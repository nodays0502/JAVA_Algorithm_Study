package Programmers.ETC;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int min = 0;
        for(int num : section){
            if(answer == 0){
                min = num;
                answer++;
            }
            if(min + m <= num){
                min = num;
                answer++;
            }
        }
        return answer;
    }
}
