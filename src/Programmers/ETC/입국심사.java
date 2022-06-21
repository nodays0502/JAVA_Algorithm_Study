package Programmers.ETC;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = binearySearch(n,times);
        return answer;
    }
    private static final long START_TIME = 1L;
    private static final long END_TIME = 1_000_000_000L * 1_000_000_000L;
    private long binearySearch(int n,int[] times){
        long start = START_TIME;
        long end = END_TIME;
        long result = 0;
        while(start <= end){
            long mid = (start + end) / 2;
            if(checkInTime(n,times,mid)){
                result = mid;
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        return result;
    }
    private boolean checkInTime(int n , int[] times, long totalTime){
        long cnt = 0;
        for(int time : times){
            cnt += totalTime / time;
        }
        if(cnt >= n){
            return true;
        }else{
            return false;
        }
    }
}
