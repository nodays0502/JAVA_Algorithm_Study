package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_19621 {
    private static class Class{
        int startTime;
        int endTime;
        int peopleCnt;

        public Class(int startTime, int endTime, int peopleCnt) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.peopleCnt = peopleCnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        List<Class> classes = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int startTime = stoi.apply(st.nextToken());
            int endTime = stoi.apply(st.nextToken());
            int peopleCnt = stoi.apply(st.nextToken());
            classes.add(new Class(startTime,endTime,peopleCnt));
        }
        classes.sort((o1,o2) -> o1.startTime - o2.startTime);
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int result = dfs(0,0,classes,n,dp);
        System.out.println(result);
    }

    private static final int NOT_VALID = -1;

    private static int dfs(int depth, int time ,List<Class> classes, int n, int[] dp) {
        if(depth >= n) {
            return 0;
        }
        if(dp[depth] != NOT_VALID) {
            return dp[depth];
        }
        int result = 0;
        for(int i = depth ; i < n ; i++){
            if(time <= classes.get(i).startTime){
                result = Math.max(result, dfs(i+1, classes.get(i).endTime,classes,n,dp) + classes.get(i).peopleCnt);
            }
        }
        dp[depth] = result;
        return result;
    }
}
