package Programmers.ETC;

public class 평균_구하기 {
    public double solution(int[] arr) {
        double answer = 0;
        long sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i];
        }
        answer = (double)sum / arr.length;
        return answer;
    }
}
