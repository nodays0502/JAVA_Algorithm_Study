package BOJ.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7568 {
    private static class Info{
        int weight;
        int height;
        public Info(int weight, int height){
            this.weight = weight;
            this.height = height;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Info[] infos = new Info[n];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            infos[i] = new Info(weight,height);
        }
        int[] cnt = new int[n];
        Arrays.fill(cnt,1);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(infos[i].weight > infos[j].weight && infos[i].height > infos[j].height){
                    cnt[j]++;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            System.out.print(cnt[i]+" ");
        }
    }
}
