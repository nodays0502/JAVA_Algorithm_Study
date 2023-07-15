package Programmers.ETC;

public class 도둑질 {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0],money[1]);
        dp2[1] = money[1];
        int size = money.length;
        for(int i = 2 ; i < size ; i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+money[i]);
            if(i == size-1){
                continue;
            }
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+money[i]);
        }
        answer = Math.max(dp1[size-2],dp2[size-1]);
        return answer;
    }
}
