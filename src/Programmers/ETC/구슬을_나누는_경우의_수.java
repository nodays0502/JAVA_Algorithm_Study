package Programmers.ETC;

public class 구슬을_나누는_경우의_수 {
    private static final int SIZE = 30;
    public int solution(int balls, int share) {
        int answer = 0;
        int[][] dp = new int[SIZE+1][SIZE+1];
        answer = cal(balls,share,dp);
        return answer;
    }
    private int cal(int balls,int share, int[][] dp){
        if(dp[balls][share] != 0){
            return dp[balls][share];
        }
        if(balls == share || share == 0){
            return 1;
        }else{
            return dp[balls][share] = cal(balls-1,share-1,dp) + cal(balls-1,share,dp);
        }
    }
}
