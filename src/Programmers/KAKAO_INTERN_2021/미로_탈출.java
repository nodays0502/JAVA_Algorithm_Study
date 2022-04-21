package Programmers.KAKAO_INTERN_2021;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 미로_탈출 {
    private static class Node{
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
        public String toCheckVisited(){
            return now+","+trap;
        }
    }
    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        int[][] map = new int[n+1][n+1];
        Map<Integer,Integer> isTrap = new HashMap<>();
        init(map,isTrap,traps,roads);
        answer = dij(map,isTrap,traps,start,end,n);
        return answer;
    }
    private static final int INF = 987654321;
    private static int dij(int[][] map,Map<Integer,Integer>isTrap,int[] traps,int start,int end,int n){
        Map<String,Integer> visited = new HashMap<>();
        // boolean[][] visited = new boolean[n+1][1>>n];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.weight - o2.weight;
        });
        Node startNode = new Node(start,0,0);
        pq.offer(startNode);
        visited.put(startNode.toCheckVisited(),0);
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
                    tempTrap = tempTrap ^ (1 << temp);
                }
                if(map[now][i] > 0 && ((!nowTrap[now] && !nowTrap[i])
                    || (nowTrap[now] && nowTrap[i]))){
                    tempWeight += map[now][i];
                }else if( (nowTrap[now] || nowTrap[i]) && map[i][now] > 0 ){
                    tempWeight += map[i][now];
                }
                if(tempWeight == weight){
                    continue;
                }
                Node next = new Node(i,tempTrap,tempWeight);
                if(visited.getOrDefault(next.toCheckVisited(),INF) > tempWeight){
                    visited.put(next.toCheckVisited(),tempWeight);
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
            if(map[a][b] == 0){
                map[a][b] = weight;
            }else{
                map[a][b] = Math.min(map[a][b],weight);
            }
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
            if( (num & 1<<i) > 0){
                int temp = traps[i];
                booleanIsTrap[temp] = true;
            }
        }
        return booleanIsTrap;
    }
}
