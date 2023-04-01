package Programmers.ETC;

public class 택배_배달과_수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delIndex = -1;
        int pickIndex = -1;
        for(int i = 0 ; i < n ; i++){
            if(deliveries[i] > 0) {
                delIndex = i;
            }
            if(pickups[i] > 0) {
                pickIndex = i;
            }
        }
        while(delIndex > -1 || pickIndex > -1){
            answer += 2 * Math.max(delIndex+1, pickIndex+1);
            int cnt = 0;
            while(delIndex > -1 && cnt < cap){
                deliveries[delIndex]--;
                while(delIndex >= 0 && deliveries[delIndex] <= 0){
                    delIndex--;
                }
                cnt++;
            }
            cnt = 0;
            while(pickIndex > -1 && cnt < cap){
                pickups[pickIndex]--;
                while(pickIndex >= 0 && pickups[pickIndex] <= 0){
                    pickIndex--;
                }
                cnt++;
            }
        }
        return answer;
    }
}
