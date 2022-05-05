package Programmers.KAKAO_INTERN_2020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class 동굴_탐험 {
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        List<Integer>[] list = new List[n];

        for(int i = 0 ; i < n ; i++){
            list[i] = new LinkedList<>();
        }
        for(int[] edge : path){
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        boolean[] isLocked = new boolean[n];
        Map<Integer,Integer> key = new HashMap<>();
        for(int[] keyAndLock : order){
            isLocked[keyAndLock[1]] = true;
            key.put(keyAndLock[0],keyAndLock[1]);
        }
        answer = cal(list,isLocked,key,n);
        return answer;
    }
    private static boolean cal(List<Integer>[] list, boolean[] isLocked, Map<Integer,Integer> key, int n){
        if(isLocked[0]){
            return false;
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visitedLockRoom = new HashSet<>();
        q.offer(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                // System.out.println(Arrays.toString(isLocked));
                // System.out.println(now);
                visited[now] = true;

                if(key.containsKey(now)){
                    int room = key.get(now);
                    isLocked[room] = false;
                    if(visitedLockRoom.contains(room)){
                        q.offer(room);
                    }
                }
                for(int next : list[now]){
                    if(isLocked[next]){
                        visitedLockRoom.add(next);
                        continue;
                    }
                    if(!visited[next]){
                        q.offer(next);
                    }
                }
            }
        }
        for(boolean value : visited){
            if(!value){
                return false;
            }
        }
        return true;
    }
}
