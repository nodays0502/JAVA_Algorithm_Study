package Programmers.ETC;

public class 치킨_쿠폰 {
    public int solution(int chicken) {
        int answer = 0;
        int chance = 0;
        while(true){
            int div = chicken / 10;
            answer += div;
            chicken %= 10;
            chicken += div;
            if(chicken < 10){
                break;
            }
        }
        return answer;
    }
}
