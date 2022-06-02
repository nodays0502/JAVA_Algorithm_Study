package Programmers.ETC;

public class 기지국_설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int prev = 1;
        int divide = 2 * w + 1;
        for(int i = 0 ; i <= stations.length ; i++){
            int now = n + 1;
            if(i != stations.length){
                now = stations[i] - w;
            }
            if(now - prev > 0){
                answer += (now - prev) / divide;
                if( (now - prev) % divide != 0 ){
                    answer++;
                }
            }
            prev = now + 2 * w + 1;
        }
        return answer;
    }
}
