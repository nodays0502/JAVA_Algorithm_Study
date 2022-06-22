package Programmers.ETC;

import java.util.Arrays;

public class 섬_연결하기 {
    public int solution(int n, int[][] costs) {
        int answer = kruskal(n,costs);
        return answer;
    }

    private int findSet(int now, int[] parent){
        if(now == parent[now]){
            return now;
        }
        return parent[now] = findSet(parent[now], parent);
    }
    private boolean unionSet(int a,int b,int[] parent){
        int aParent = findSet(a, parent);
        int bParent = findSet(b, parent);
        if(aParent == bParent){
            return false;
        }
        parent[aParent] = bParent;
        return true;
    }
    private int kruskal(int n, int[][] costs){
        int[] parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        Arrays.sort(costs,(o1,o2)->{
            return o1[2] - o2[2];
        });
        int result = 0;
        for(int[] edge : costs){
            if(unionSet(edge[0],edge[1],parent)){
                result += edge[2];
            }
        }
        return result;
    }
}
