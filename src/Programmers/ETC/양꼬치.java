package Programmers.ETC;

public class 양꼬치 {
    private static final int LAMB_PRICE = 12_000;
    private static final int DRINK_PRICE = 2_000;
    public int solution(int n, int k) {
        int answer = LAMB_PRICE * n + DRINK_PRICE * Math.max(k - n / 10,0);
        return answer;
    }
}