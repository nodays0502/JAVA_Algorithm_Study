package Programmers.ETC;

public class 하샤드_수 {
    public boolean solution(int x) {
        int sum = 0;
        int temp = x;
        while(temp > 0){
            sum += temp % 10;
            temp /= 10;
        }
        boolean answer = x % sum == 0;
        return answer;
    }
}
