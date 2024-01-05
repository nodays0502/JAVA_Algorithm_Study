package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2565_2 {
    private static class Edge{
        int a;
        int b;
        public Edge(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Edge> edges = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b));
        }
        Collections.sort(edges,(v1,v2)->{
            return v1.a - v2.a;
        });
        int[] LIS = new int[n];
        int max = 1;
        Arrays.fill(LIS,1);
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(edges.get(i).b < edges.get(j).b && LIS[i] + 1 > LIS[j]){
                    LIS[j] = LIS[i] + 1;
                    max = Math.max(LIS[j], max);
                }
            }
        }
        System.out.println(n - max);
    }
}
