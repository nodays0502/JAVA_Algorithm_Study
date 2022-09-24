package Programmers.PCCP_모의고사_1;

public class NO_2 {
    public int solution(int[][] ability) {
        int peopleCnt = ability.length;
        int sportCnt = ability[0].length;
        boolean[] used = new boolean[peopleCnt];
        int answer = cal(0,used,ability,peopleCnt,sportCnt);
        return answer;
    }
    private static int cal(int depth, boolean[] used,int[][] ability,int peopleCnt,int sportCnt){
        if(depth == sportCnt){
            return 0;
        }
        int result = 0;
        for(int i = 0 ; i < peopleCnt ; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            result = Math.max(result,cal(depth+1,used,ability,peopleCnt,sportCnt)+ability[i][depth]);
            used[i] = false;
        }
        return result;
    }
}
