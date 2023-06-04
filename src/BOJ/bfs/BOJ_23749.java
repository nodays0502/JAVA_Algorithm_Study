package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_23749 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] isO = new boolean[2*n];
        for(int i = 0 ; i < 2*n ; i++){
            if(st.nextToken().charAt(0) == 'O'){
                isO[i] = true;
            }
        }
        int result = cal(isO,2*n);
        System.out.println(result);
    }

    private static int cal(boolean[] isO, int n) {
        int time = 0;
        Queue<boolean[]> q = new LinkedList<>();
        q.offer(isO);
        Set<String> visited = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                boolean[] now = q.poll();
                if(isWin(now,n)){
                    return time;
                }
                for(int i = 0 ; i < n ; i++){
                    boolean[] next = change(i,now,n);
                    if(!visited.contains(Arrays.toString(next))){
                        q.offer(next);
                        visited.add(Arrays.toString(next));
                    }
                }
            }
            time++;
        }
        return -1;
    }

    private static boolean[] change(int index, boolean[] now, int n) {
        boolean[] temp = Arrays.copyOf(now,now.length);
        boolean flag = now[index];
        for(int i = index ; i > 0 ; i--){
            temp[i] = temp[i-1];
        }
        temp[0] = flag;
        return temp;
    }

    private static boolean isWin(boolean[] now,int n) {
        int[] score = new int[2];
        for(int i = 0 ; i < n ; i += 2){
            if(now[i] == now[i+1]){
                continue;
            }
            if(now[i]){
                score[0]++;
            }else {
                score[1]++;
            }
        }
        if(score[0] > score[1]){
            return true;
        }
        return false;
    }
}
