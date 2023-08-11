package Programmers.ETC;

public class 택배_배달과_수거하기2 {
    private static final int NOT_FOUND = -1;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delIndex = NOT_FOUND;
        int pickIndex = NOT_FOUND;
        for(int i = n - 1; i >= 0 ; i--){
            if(deliveries[i] > 0 && delIndex == NOT_FOUND){
                delIndex = i;
            }
            if(pickups[i] > 0 && pickIndex == NOT_FOUND){
                pickIndex = i;
            }
        }
        while(delIndex > -1 || pickIndex > -1){
            answer += 2 * Math.max(delIndex+1,pickIndex+1);
            int cnt = 0;
            while(delIndex > -1 && cnt < cap){
                deliveries[delIndex]--;
                cnt++;
                while(delIndex > -1 && deliveries[delIndex] == 0){
                    delIndex--;
                }
            }
            cnt = 0;
            while(pickIndex > -1 && cnt < cap){
                pickups[pickIndex]--;
                cnt++;
                while(pickIndex > -1 && pickups[pickIndex] == 0){
                    pickIndex--;
                }
            }
        }
        return answer;
    }
}
