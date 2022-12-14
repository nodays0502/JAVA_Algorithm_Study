package Programmers.ETC;

public class 배열의_평균값 {
    public double solution(int[] numbers) {
        double answer = 0;
        int sum = 0;
        for(int num : numbers){
            sum += num;
        }
        answer = (double)sum / numbers.length;
        return answer;
    }
}
