package Programmers.KAKAO_BLIND_2021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 카드_짝_맞추기 {
    static class Node{
        int y;
        int x;
        int[][] map;
        int card;

        public Node(int y, int x , int[][] map , int card){
            this.y = y;
            this.x = x;
            this.map = map;
            this.card = card;
        }

        public boolean openCard(){
            if(map[y][x] == 0){
                return false;
            }
            if(card == 0){
                card = map[y][x];
                map[y][x] = 0;
                return true;
            }else if(card == map[y][x]){
                map[y][x] = 0;
                card = 0;
                // System.out.println("remove");
                // System.out.println(this);
                return true;
            }
            return false;
        }

        public Node copy(){
            Node temp = new Node(y,x,map,card);
            temp.map = copyArr(this.map,SIZE);
            return temp;
        }

        public boolean checkClear(){
            for(int i = 0 ; i < SIZE ; i++){
                for(int j = 0 ; j < SIZE ; j++){
                    if(map[i][j] != 0){
                        return false;
                    }
                }
            }
            return true;
        }
        public String toString(){
            return y + "," + x + "," + Arrays.deepToString(map) + "," + card;
        }
    }
    public int solution(int[][] board, int r, int c) {
        int answer = 0;
        answer = bfs(board,r,c);
        return answer;
    }

    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};

    private static final int SIZE = 4;

    private static int bfs(int[][] board, int r, int c){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r,c,board,0));
        Set<String> visited = new HashSet<>();
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size; s++){
                Node now = q.poll();
                // System.out.println(now);
                int y = now.y;
                int x = now.x;
                int[][] map = now.map;
                int card = now.card;
                Node node = now.copy();
                if(node.openCard() && !visited.contains(node.toString())){
                    if(node.checkClear()){
                        return time + 1;
                    }
                    visited.add(node.toString());
                    q.offer(node);
                }
                for(int i = 0 ; i < 4; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(checkBound(ny,nx,SIZE)){
                        Node temp = new Node(ny,nx,map,card);
                        if(!visited.contains(temp.toString())){
                            visited.add(temp.toString());
                            q.offer(temp);
                        }
                    }
                    while(checkBound(ny,nx,SIZE) && map[ny][nx] == 0){
                        ny += dy[i];
                        nx += dx[i];
                    }
                    if(!checkBound(ny,nx,SIZE)){
                        ny -= dy[i];
                        nx -= dx[i];
                    }

                    Node temp = new Node(ny,nx,map,card);
                    if(!visited.contains(temp.toString())){
                        visited.add(temp.toString());
                        q.offer(temp);
                    }
                }
            }
            time++;
            // if(time == 3){
            //     break;
            // }
        }
        return -1;
    }
    private static boolean checkBound(int ny,int nx,int size){
        if(ny >= 0 && ny < size && nx >= 0 && nx < size){
            return true;
        }
        return false;
    }

    public static int[][] copyArr(int[][] arr,int n){
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }
}
