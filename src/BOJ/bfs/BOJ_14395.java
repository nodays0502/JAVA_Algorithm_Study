package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14395 {
    private static class Node{
        long num;
        String operations;

        public Node(long num, String operations) {
            this.num = num;
            this.operations = operations;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int startNum = stoi.apply(st.nextToken());
        int endNum = stoi.apply(st.nextToken());
        String result = bfs(startNum,endNum);
        System.out.println(result);
    }
    private static char[] OPERATION = {'*','+','-','/'};
    private static String bfs(int startNum, int endNum) {
        if(startNum == endNum){
            return "0";
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startNum,"") );
        Set<Long> visited = new HashSet<>();
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.num == endNum){
                return now.operations;
            }
            long nextNum = now.num * now.num;
            if(!visited.contains(nextNum)){
                visited.add(nextNum);
                q.offer(new Node(nextNum,now.operations+"*"));
            }
            nextNum = now.num + now.num;
            if(!visited.contains(nextNum)){
                visited.add(nextNum);
                q.offer(new Node(nextNum,now.operations+"+"));
            }
            nextNum = now.num - now.num;
            if(!visited.contains(nextNum)){
                visited.add(nextNum);
                q.offer(new Node(nextNum,now.operations+"-"));
            }
            if(now.num == 0){
                continue;
            }
            nextNum = now.num / now.num;
            if(!visited.contains(nextNum)){
                visited.add(nextNum);
                q.offer(new Node(nextNum,now.operations+"/"));
            }
        }
        return "-1";
    }
}
