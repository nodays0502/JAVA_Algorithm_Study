package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BOJ_12919_2 {
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        System.out.println(bfs(s,t));
    }
    public static int bfs(String s,String t){
        Queue<String> q = new LinkedList<>();
        Set<String> visited  = new HashSet<>();
        q.offer(s);
        while(!q.isEmpty()){
            String now = q.poll();
            if(now.equals(t)){
                return SUCCESS;
            }
            if(now.length() >= t.length()){
                continue;
            }
            StringBuilder sb = new StringBuilder(now);
            String next = sb.append('B').reverse().toString();
            if(!visited.contains(next)){
                visited.add(next);
                q.offer(next);
            }
            next = now+'A';
            if(!visited.contains(next)){
                visited.add(next);
                q.offer(next);
            }
        }
        return FAIL;
    }
    private static void addQueue(String next, Set<String> visited,Queue<String> q){
        if(!visited.contains(next)){
            visited.add(next);
            q.offer(next);
        }
    }
}
