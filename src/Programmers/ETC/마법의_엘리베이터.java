package Programmers.ETC;

public class 마법의_엘리베이터 {
    public int solution(int storey) {
        int answer = cal(storey);
        return answer;
    }
    private static int cal(int storey){
        int num = storey;
        int result = 0;
        while(num > 0){
            int temp = num % 10;
            if(temp < 5){
                result += temp;
            }else if(temp == 5){
                int tenCnt = (num % 100) / 10;
                if(tenCnt >= 5){
                    num += 10;
                }
                result += 5;
            }else{
                result += 10-temp;
                num += 10;
            }
            num /= 10;
        }
        return result;
    }
}
