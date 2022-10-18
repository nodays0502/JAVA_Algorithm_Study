package Programmers.ETC;

public class _2개_이하로_다른_비트 {
    public long[] solution(long[] numbers) {
        int size = numbers.length;
        long[] answer = new long[size];
        for(int i = 0 ; i < size ; i++){
            if(numbers[i] % 2 == 0){
                answer[i] = numbers[i] + 1;
            }else{
                int temp = 0;
                long num = numbers[i];
                while(true){
                    if(num == 1){
                        temp++;
                        break;
                    }
                    if(num % 2 == 0){
                        break;
                    }else{
                        num /= 2;
                    }
                    temp++;
                }
                answer[i] = numbers[i] + (long)Math.pow(2,temp) - (long)Math.pow(2,temp-1);
            }
        }
        return answer;
    }
}
