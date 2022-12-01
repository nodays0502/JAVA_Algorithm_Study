package Programmers.ETC;

public class 제곱수_판별하기 {
    private static final int WRONG = 2;
    private static final int RIGHT = 1;
    public int solution(int n) {
        int answer = detect(n);
        return answer;
    }
    private int detect(int num){
        int temp = (int)Math.sqrt(num);
        if(temp* temp == num ){
            return RIGHT;
        }else{
            return WRONG;
        }
    }
}
