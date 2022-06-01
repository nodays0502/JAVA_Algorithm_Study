package Programmers.ETC;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 지형_이동 {
    private int[] makeParent(int[][] land,int size){
        int[] parent = new int[size*size];
        for(int i = 0 ; i < size*size ; i++){
            parent[i] = i;
        }
        return parent;
    }
    public int solution(int[][] land, int height) {
        int answer = kruskal(land,height);
        return answer;
    }
    private int findSet(int num, int[] parent){
        if(num == parent[num]){
            return num;
        }
        return parent[num] = findSet(parent[num], parent);
    }
    private boolean unionSet(int a, int b, int[] parent){
        int aParent = findSet(a,parent);
        int bParent = findSet(b,parent);
        if(aParent == bParent){
            return false;
        }
        parent[aParent] = bParent;
        return true;
    }
    private int findPosition(int y, int x, int size){
        return y * size + x;
    }
    private boolean checkBound(int y,int x,int size){
        if(y >= 0 && y < size && x >= 0 && x < size){
            return true;
        }
        return false;
    }

    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};

    private int kruskal(int[][] land, int height){
        int size = land.length;
        int[] parent = makeParent(land,size);
        List<int[]> list = new LinkedList<>();
        // System.out.println(Arrays.toString(parent));
        for(int y = 0 ; y < size ; y++){
            for(int x = 0 ; x < size; x++){
                for(int dir = 0 ; dir < 4 ; dir++){
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if(!checkBound(ny,nx,size)){
                        continue;
                    }
                    int weight = Math.abs(land[ny][nx] - land[y][x]);
                    if(weight <= height){
                        weight = 0;
                    }
                    list.add(new int[] {y,x,ny,nx,weight});
                }
            }
        }
        Collections.sort(list,(o1,o2)->{
            return o1[4] - o2[4];
        });
        // list.stream().map(Arrays::toString).forEach(System.out::println);
        int result = 0;
        for(int[] arr : list){
            int startPosition = findPosition(arr[0], arr[1], size);
            int endPosition = findPosition(arr[2], arr[3], size);
            if(unionSet(startPosition,endPosition,parent)){
                result += arr[4];
            }
        }
        return result;
    }
}
