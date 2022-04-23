package Programmers.ETC;

public class 피로도 {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] used = new boolean[dungeons.length];
        answer = dfs(0,k,used,dungeons);
        return answer;
    }
    private static final int NEED_FATIGUE = 0;
    private static final int FATIGUE = 1;//fatigue
    private int dfs(int depth,int k , boolean[] used,int[][] dungeons){
        if(depth == dungeons.length){
            return 0;
        }
        int result = 0;
        for(int i = 0 ; i < dungeons.length ; i++){
            if(used[i]){
                continue;
            }
            if(k < dungeons[i][NEED_FATIGUE]){
                continue;
            }
            used[i] = true;
            result = Math.max(result,dfs(depth+1,k-dungeons[i][FATIGUE],used,dungeons)+1);
            used[i] = false;
        }
        return result;
    }
}
