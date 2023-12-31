package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19621_2 {
    private static class Meeting{
        int startTime;
        int endTime;
        int peopleCnt;
        public Meeting(int startTime,int endTime, int peopleCnt){
            this.startTime = startTime;
            this.endTime = endTime;
            this.peopleCnt = peopleCnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][3];
        List<Meeting> meetings = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int peopleCnt = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start,end,peopleCnt));
        }
        meetings.sort((v1,v2)->{
            return v1.startTime - v2.startTime;
        });
        int[] dp = new int[n];
        Arrays.fill(dp,NOT_VALID);
        int result = cal(0,meetings,n,dp);
        System.out.println(result);
    }
    private static final int NOT_VALID = -1;
    private static int cal(int depth, List<Meeting> meetings, int n,int[] dp) {
        if(depth >= n){
            return 0;
        }
        if(dp[depth] != NOT_VALID){
            return dp[depth];
        }
        int result = 0;
        for(int i = depth ; i < n ; i++){
            if(meetings.get(depth).endTime <= meetings.get(i).startTime){
                result = Math.max(result,cal(i,meetings,n,dp) + meetings.get(depth).peopleCnt);
            }
        }
        result = Math.max(result,cal(n,meetings,n,dp) + meetings.get(depth).peopleCnt);
        result = Math.max(result,cal(depth+1,meetings,n,dp));
        dp[depth] = result;
        return result;
    }
}
