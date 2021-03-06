import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Test {

    public static void main(String[] args) {
        int[][] roads = new int[][] {{1,2,3},{3,2,3}};
        int[] traps = new int[] {2};
        System.out.println(solution(3,1,3,roads,traps));
    }
    static class Node{
        int now;
        int trap;
        int weight;
        public Node(int now,int trap,int weight){
            this.now = now;
            this.trap = trap;
            this.weight = weight;
        }
        @Override
        public String toString(){
            return now+","+trap+","+weight;
        }
    }
    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        int[][] map = new int[n+1][n+1];
        Map<Integer,Integer>isTrap = new HashMap<>();
        init(map,isTrap,traps,roads);
        answer = dij(map,isTrap,traps,start,end,n);
        return answer;
    }
    private static int dij(int[][] map,Map<Integer,Integer>isTrap,int[] traps,int start,int end,int n){
        Set<String> visited = new HashSet<>();
        // boolean[][] visited = new boolean[n+1][1>>n];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.weight - o2.weight;
        });
        pq.offer(new Node(start,0,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            System.out.println(node);
            if(node.now == end){
                return node.weight;
            }
            int now = node.now;
            int weight = node.weight;
            boolean[] nowTrap = trapNumber(traps,node.trap,n);
            for(int i = 1 ; i <= n ; i++){
                if(i == now){
                    continue;
                }
                int tempTrap = node.trap;
                int temp = checkIsTrap(isTrap,i);
                int tempWeight = weight;
                if(temp != -1){
                    tempTrap = tempTrap ^ 1 >> temp;
                }
                boolean flag = false;
                System.out.println(i+" "+map[now][i]);
                System.out.println(Arrays.toString(nowTrap));
                if(map[now][i] > 0 && (!nowTrap[now] || (nowTrap[now] && nowTrap[i]))){
                    tempWeight += map[now][i];
                    System.out.println("1st:"+tempWeight);
                }
                if(nowTrap[now] && !nowTrap[i] && map[i][now] > 0 ){
                    tempWeight += map[i][now];
                    System.out.println("2nd"+tempWeight);
                }
                if(tempWeight == weight){
                    continue;
                }
                Node next = new Node(i,tempTrap,tempWeight);
                if(!visited.contains(next.toString())){
                    visited.add(next.toString());
                    pq.offer(next);
                }
            }
        }
        return -1;
    }
    private static void init(int[][] map, Map<Integer,Integer> isTrap,int[] traps ,int[][] roads){
        for(int[] road : roads){
            int a = road[0];
            int b = road[1];
            int weight = road[2];
            map[a][b] = weight;
        }
        int index = 0;
        for(int trap : traps){
            isTrap.put(trap,index++);
        }
    }
    private static int checkIsTrap(Map<Integer,Integer>isTrap,int num){
        return isTrap.getOrDefault(num,-1);
    }
    private static boolean[] trapNumber(int[] traps,int num,int n){
        boolean[] booleanIsTrap = new boolean[n+1];
        if(num == 0){
            return booleanIsTrap;
        }
        for(int i = 0 ; i < 10 ; i++){
            if( (num & 1>>i) > 0){
                int temp = traps[i];
                booleanIsTrap[temp] = true;
            }
        }
        return booleanIsTrap;
    }
}