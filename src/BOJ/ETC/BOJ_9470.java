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

public class BOJ_9470 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for (int t = 1; t <= test; t++) {
            st = new StringTokenizer(br.readLine());
            int k = stoi.apply(st.nextToken());
            int n = stoi.apply(st.nextToken());
            int m = stoi.apply(st.nextToken());
            List<Integer>[] map = new ArrayList[n + 1];
            int[] count = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                map[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = stoi.apply(st.nextToken());
                int b = stoi.apply(st.nextToken());
                map[a].add(b);
                count[b]++;
            }
            System.out.printf("%d %d\n", k, bfs(map, count, n));
        }
    }
    private static class Node{
        int location;
        int number;

        public Node(int location, int number) {
            this.location = location;
            this.number = number;
        }
    }
    private static int bfs(List<Integer>[] map, int[] count, int n) {
        int[] number = new int[n+1];
        boolean[] isNumber = new boolean[n+1];
        Queue<Node> q = new LinkedList<>();
        int result = 1;
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                q.offer(new Node(i,1));
            }
        }
        while (!q.isEmpty()) {
            Node now = q.poll();
//            System.out.println(now.location+" "+now.number);
//            System.out.println(Arrays.toString(number));
//            System.out.println(Arrays.toString(count));
            for (int i = 0; i < map[now.location].size(); i++) {
                int next = map[now.location].get(i);
                if (--count[next] == 0) {
                    if(number[next] == now.number || isNumber[next]){
                        q.offer(new Node(next,number[next]+1));
                        result = Math.max(number[next]+1,result);
                    }else{
                        q.offer(new Node(next,Math.max(now.number,number[next])));
                    }
                }else{
                    if(number[next] == now.number){
                        isNumber[next] = true;
                    }else{
                        isNumber[next] = false;
                        number[next] = Math.max(now.number,number[next]);
                    }
                }
            }
        }
        return result;
    }
}
