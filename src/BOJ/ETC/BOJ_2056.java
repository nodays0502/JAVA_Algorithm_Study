package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2056 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] cnt = new int[n];
        int[] needTime = new int[n];
        List<Integer>[] map = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            needTime[i] = stoi.apply(st.nextToken());
            int inputCnt = stoi.apply(st.nextToken());
            cnt[i] = inputCnt;
            for(int j = 0 ; j < inputCnt; j++){
                int num = stoi.apply(st.nextToken())-1;
                map[num].add(i);
            }
        }
        System.out.println(cal(cnt,map,needTime,n));
    }

    private static int cal(int[] cnt, List<Integer>[] map, int[] needTime,int n) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(cnt[i] == 0){
                q.offer(new int[] {i,0});
            }
        }
        int result = 0;
        int[] endTime = new int[n];
        while(!q.isEmpty()){
            int[] now = q.poll();
            result = Math.max(result,now[1] + needTime[now[0]]);
            for(int i = 0 ; i < map[now[0]].size(); i++){
                int next = map[now[0]].get(i);
                endTime[next] = Math.max(endTime[next], now[1] + needTime[now[0]]);
                if(--cnt[next] == 0){
                    q.offer(new int[] {next,endTime[next]});
                }
            }
        }
        return result;
    }
}
