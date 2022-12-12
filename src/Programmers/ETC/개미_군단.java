package Programmers.ETC;

public class 개미_군단 {
    private static final int[] DAMAGE = {5,3,1};
    private static final int INF = 987654321;
    public int solution(int hp) {
        int[][] dp = new int[hp+1][3];
        int answer = cal(0,hp,dp);
        return answer;
    }
    private int cal(int depth, int hp,int[][] dp){
        if(hp == 0){
            return 0;
        }
        if(depth >= 3){
            return INF;
        }
        if(dp[hp][depth] != 0){
            return dp[hp][depth];
        }
        int result = INF;
        for(int i = hp / DAMAGE[depth] ; i >= 0 ; i--){
            result = Math.min(result,cal(depth+1, hp-i * DAMAGE[depth], dp)+i);
        }
        dp[hp][depth] = result;
        return result;
    }
}
