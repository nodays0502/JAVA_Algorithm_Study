package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1966 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for(int t = 0 ; t < test ; t++){
            st = new StringTokenizer(br.readLine()," ");
            int n = stoi.apply(st.nextToken());
            int m = stoi.apply(st.nextToken());
            int[] cnt = new int[10];
            Queue<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0 ; i < n ; i++){
                int num = stoi.apply(st.nextToken());
                cnt[num]++;
                q.offer(new int[]{num,i});
            }
            int time = 0;
            while(!q.isEmpty()){
                int[] now = q.poll();
//                System.out.println(Arrays.toString(now));
                int max = findMax(cnt);
                if(now[0] == max){
                    cnt[max]--;
                    time++;
                    if(now[1] == m){
                        break;
                    }
                }else{
                    q.offer(now);
                }
            }
            System.out.println(time);
        }
    }

    private static int findMax(int[] cnt) {
        for(int i = 9 ; i >= 0 ; i--){
            if(cnt[i] != 0){
                return i;
            }
        }
        return -1;
    }
}
