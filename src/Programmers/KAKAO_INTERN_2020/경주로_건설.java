package Programmers.KAKAO_INTERN_2020;

import java.util.PriorityQueue;

public class 경주로_건설 {
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};

    private static final int DIRECT_COST = 100;
    private static final int CORNER_COST = 500;

    private static final int EMPTY = 0;
    private static final int BLOCK = 1;

    public int solution(int[][] board) {
        int answer = 0;
        answer = bfs(board);
        return answer;
    }
    private static class Node{
        int[] position;
        int dir;
        int cost;

        public Node(int[] position,int dir,int cost){
            this.position = position;
            this.dir = dir;
            this.cost = cost;
        }
    }
    private static int bfs(int[][] board){
        int n = board.length;
        int m = board[0].length;
        int[][][] dp = new int[n][m][4]; // y,x,dir
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.cost - o2.cost;
        });
        pq.offer(new Node(new int[]{0,0},1,0));
        pq.offer(new Node(new int[]{0,0},2,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.position[0] == n-1 && now.position[1] == m-1){
                return now.cost;
            }
            for(int i = -1 ; i <= 1 ; i++){
                int nextDir = (now.dir + i + 4) % 4;
                int ny = now.position[0]+dy[nextDir];
                int nx = now.position[1]+dx[nextDir];
                int nextCost = now.cost + DIRECT_COST;
                if(i != 0){
                    nextCost += CORNER_COST;
                }
                if(checkBound(ny,nx,n,m) &&
                    board[ny][nx] == EMPTY &&
                    (dp[ny][nx][nextDir] == 0 ||
                        dp[ny][nx][nextDir] > nextCost)){
                    dp[ny][nx][nextDir] = nextCost;
                    pq.offer(new Node(new int[] {ny,nx},nextDir,nextCost));
                }
            }
        }
        return -1;
    }
    private static boolean checkBound(int y,int x, int n,int m){
        if(y >=0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
