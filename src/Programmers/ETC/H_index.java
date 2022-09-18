package Programmers.ETC;

public class H_index {
    private static final int INF = 10_000;
    public int solution(int[] citations) {
        int answer = 0;
        int[] cnt = new int[INF+1];
        int size = citations.length;
        for(int citation : citations){
            cnt[citation]++;
        }
        int sum = 0;
        for(int i = INF ; i >= 0 ; i--){
            sum += cnt[i];
            if(sum >= i && size - sum <= i){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
