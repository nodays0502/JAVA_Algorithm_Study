package Programmers.ETC;

public class 아이스_아메리카노 {
    private static final int COFFEE_PRICE = 5_500;
    public int[] solution(int money) {
        int[] answer = new int[2];
        answer[0] = money / COFFEE_PRICE;
        answer[1] = money % COFFEE_PRICE;
        return answer;
    }
}
