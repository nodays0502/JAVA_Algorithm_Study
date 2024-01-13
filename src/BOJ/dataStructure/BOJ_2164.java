package BOJ.dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            q.offer(i);
        }
        int[] result = new int[n];
        int index = 0;
        while(!q.isEmpty()){
            for(int i = 0 ; i < k-1 ; i++){
                q.offer(q.poll());
            }
            result[index++] = q.poll();
        }
        print(result,n);
    }

    private static void print(int[] result, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0 ; i < n ; i++){
            sb.append(result[i]+", ");
        }
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb.toString());
    }
}
