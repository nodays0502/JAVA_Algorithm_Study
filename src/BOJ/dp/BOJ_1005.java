package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1005 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int testCnt = stoi.apply(st.nextToken());
        for(int t = 0 ; t < testCnt ; t++){
            st = new StringTokenizer(br.readLine());
            int n = stoi.apply(st.nextToken());
            int k = stoi.apply(st.nextToken());
            int[] hour = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <= n ; i++){
                hour[i] = stoi.apply(st.nextToken());
            }
            List<Integer>[] list = new List[n+1];
            for(int i = 1 ; i <= n ; i++){
                list[i] = new LinkedList<>();
            }
            int[] cnt = new int[n+1];
            for(int i = 0 ; i < k ; i++){
                st = new StringTokenizer(br.readLine());
                int start = stoi.apply(st.nextToken());
                int end = stoi.apply(st.nextToken());
                list[start].add(end);
                cnt[end]++;
            }
            int endPosition = stoi.apply(br.readLine());
            int result = cal(endPosition,list,hour,cnt,n);
            System.out.println(result);
        }
    }
    private static final int NOT_FOUND = -1;
    private static int cal(int target,List<Integer>[] list, int[] hour ,int[] cnt, int n) {
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        boolean[] visited = new boolean[n+1];
        for(int i = 1 ; i <= n ; i++){
            if(cnt[i] == 0){
                q.offer(new int[]{hour[i],i});
            }
        }
        int[] receivedTime = new int[n+1];
        while(!q.isEmpty()){
            int[] now = q.poll();
            int endTime = now[0];
            int nowPosition = now[1];
            if(nowPosition == target){
                return endTime;
            }
            for(int next : list[nowPosition]){
                cnt[next]--;
                receivedTime[next] = Math.max(receivedTime[next],endTime);
                if(!visited[next] && cnt[next] == 0){
                    q.offer(new int[]{receivedTime[next]+hour[next],next});
                    time = Math.max(time,receivedTime[next]+hour[next]);
                    visited[next] = true;
                }
            }
        }
        return NOT_FOUND;
    }
}
