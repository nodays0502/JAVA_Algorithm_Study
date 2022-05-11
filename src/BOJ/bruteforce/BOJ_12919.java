package BOJ.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BOJ_12919 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        System.out.println(bfs(S,T));
    }
    private static int bfs(String start,String target){
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(target);
        q.offer(target);
        while(!q.isEmpty()){
            String now = q.poll();
            if(now.length() == start.length() && now.equals(start)){
                return 1;
            }
            if(now.length() <= start.length()){
                continue;
            }
            if(now.charAt(now.length()-1) == 'A'){
                String temp = new StringBuilder(now).deleteCharAt(now.length() - 1).toString();
                if(!visited.contains(temp)){
                    visited.add(temp);
                    q.offer(temp);
                }
            }
            if(now.charAt(0) == 'B'){
                String temp = new StringBuilder(now).reverse().deleteCharAt(now.length() - 1).toString();
                if(!visited.contains(temp)){
                    visited.add(temp);
                    q.offer(temp);
                }
            }
        }
        return 0;
    }
}
