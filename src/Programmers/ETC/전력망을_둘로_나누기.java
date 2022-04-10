package Programmers.ETC;

public class 전력망을_둘로_나누기 {
    public int solution(int n, int[][] wires) {
        int answer = 100;
        int[] parent = new int[n+1];
        for(int i = 0 ; i < wires.length ; i++){
            init(parent,n);
            for(int j = 0 ; j < wires.length ; j++){
                if(i == j){
                    continue;
                }
                Union(parent,wires[j][0] , wires[j][1]);
            }
            answer = Math.min(answer,calDiff(parent,n));
        }
        return answer;
    }
    private int calDiff(int[] parent, int n){
        int top = findSet(parent,1);
        int[] result = new int[] {0,0};
        for(int i = 1; i <= n ; i++){
            if(findSet(parent,i) == top){
                result[0]++;
            }else{
                result[1]++;
            }
        }
        // System.out.println(Arrays.toString(parent));
        // System.out.println(Math.abs(result[0] - result[1]));
        return Math.abs(result[0] - result[1]);
    }
    private void init (int[] parent, int n){
        for(int i = 0 ; i <= n ; i++){
            parent[i] = i;
        }
    }
    private int findSet(int[] parent , int now){
        if(now == parent[now]){
            return now;
        }
        return parent[now] = findSet(parent,parent[now]);
    }
    private void Union(int[] parent, int a, int b){
        int aParent = findSet(parent,a);
        int bParent = findSet(parent,b);
        if(aParent != bParent){
            parent[aParent] = bParent;
        }
    }
}
