package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1939 {
    private static class Node{
        int end;
        long weight;

        public Node(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        Function<String,Long> stol = Long::parseLong;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Node> list[] = new List[n+1];
        for(int i = 1 ; i <= n ; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            long c = stol.apply(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine()," ");
        int start = stoi.apply(st.nextToken());
        int end = stoi.apply(st.nextToken());
        long result = cal(list,start,end,n);
        System.out.println(result);
    }

    private static long cal(List<Node>[] list, int start, int end, int n) {
        long[] distance = new long[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance,0);

        distance[start] = Long.MAX_VALUE;
        long result = 0;
        for(int i = 0 ; i < n ; i++){
            int maxIndex = 1;
            long maxValue = 0;
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && distance[j] > maxValue){
                    maxValue = distance[j];
                    maxIndex = j;
                }
            }
//            System.out.println(maxIndex);
//            System.out.println(Arrays.toString(distance));
            if(maxIndex == end){
                result = maxValue;
                break;
            }
            visited[maxIndex] = true;
            for(int j = 0 ; j < list[maxIndex].size(); j++){
                Node node = list[maxIndex].get(j);
                int next = node.end;
                long weight = Math.min(node.weight,maxValue);
                if(distance[next] < weight){
                    distance[next] = weight;
                }
            }
        }
        return result;
    }
}
