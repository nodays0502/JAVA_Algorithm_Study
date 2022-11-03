package Programmers.ETC;

public class 중복된_숫자 {
    public int solution(int[] array, int n) {
        int answer = 0;
        for(int num : array){
            if(n == num){
                answer++;
            }
        }
        return answer;
    }
}
