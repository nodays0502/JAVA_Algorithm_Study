package Programmers.ETC;

public class 옷가게_할인_받기 {
    private static final int[] PRICE = {100_000, 300_000, 500_000};
    private static final int[] SALE = {95, 90, 80};

    public int solution(int price) {
        int answer = price;
        for(int i = 2 ; i >= 0 ; i--){
            if(price >= PRICE[i]){
                answer = (price * SALE[i]) / 100;
                break;
            }
        }
        return answer;
    }
}
