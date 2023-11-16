package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] weight = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            weight[i] =  Integer.parseInt(st.nextToken());
        }
        long result = cal(weight,n,w,l);
        System.out.println(result);
    }

    private static long cal(int[] weight, int n, int w, int l) {
        int totalWeight = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            boolean flag = false;
            while(totalWeight + weight[i] > l){
                int[] temp = q.poll();
                totalWeight -= temp[0];
                if(temp[1] + w > time){
                    flag = true;
                }
                time = Math.max(temp[1] + w,time); // 끝나는 시간
            }
            totalWeight += weight[i];
            if(!flag){
                time++;
            }
            q.offer(new int[]{weight[i],time}); // 들어가기 직전 시간
        }
        while(!q.isEmpty()){
            time = Math.max(q.poll()[1] + w,time);
        }
        return time;
    }

}
