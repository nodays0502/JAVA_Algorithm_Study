package Programmers.ETC;

public class N_Queen {
    public static class Node{
        int y;
        int x;
        public Node(int y,int x){
            this.y = y;
            this.x = x;
        }
    }
    public int solution(int n) {
        int answer = 0;
        // answer = cal(0,0,0,map,check,n);
        Node[] visited = new Node[n];
        answer = cal(visited,0,0,n);
        return answer;
    }
    private static int cal(Node[] visited, int y,int depth, int n){
        if(depth == n){
            return 1;
        }
        if(y >= n){
            return 0;
        }
        int result = 0;
        for(int x = 0 ; x < n ; x++){
            if(!checkVisited(y,x,depth,visited)){
                visited[depth] = new Node(y,x);
                result += cal(visited,y+1,depth+1,n);
            }
        }
        return result;
    }
    private static boolean checkVisited(int y,int x,int depth,Node[] visited){
        for(int i = 0 ; i < depth ; i++){
            Node node = visited[i];
            if(Math.abs(y-node.y) == Math.abs(x-node.x)){
                return true;
            }
            if(y == node.y || x == node.x){
                return true;
            }
        }
        return false;
    }
}
