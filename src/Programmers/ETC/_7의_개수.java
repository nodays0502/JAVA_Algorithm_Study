package Programmers.ETC;

public class _7의_개수 {
    public int solution(int[] array) {
        int answer = 0;
        for(int num : array){
            answer += cal(num);
        }
        return answer;
    }
    private int cal(int num){
        int result = 0;
        while(num > 0){
            if(num % 10 == 7){
                result++;
            }
            num /= 10;
        }
        return result;
    }
}
