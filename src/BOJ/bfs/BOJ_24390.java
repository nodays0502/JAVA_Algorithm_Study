package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;

public class BOJ_24390 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        String[] temp = command.split(":");
        Function<String,Integer> stoi = Integer::parseInt;
        int min = stoi.apply(temp[0]);
        int sec = stoi.apply(temp[1]);
        sec += min * 60;
        int result = cal(sec);
        System.out.println(result);
    }
    private static final int[] BUTTON = {10,60,600,30};
    private static int cal(int sec) {
        if(sec == 30){
            return 1;
        }
        Queue<Integer>  q = new LinkedList<>();
        q.offer(0);
        Set<Integer> visited = new HashSet<>();
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                if(now/10 == sec){
                    if(now % 10 == 1){
                        return time;
                    }else{
                        return time+1;
                    }
                }
                for(int i = 0 ; i < 4 ; i++){
                    int next = now + 10 * BUTTON[i];
                    if(i == 3 && next % 10 == 0){
                        next += 1;
                    }
                    if(!visited.contains(next) && next/10 <= sec){
                        q.offer(next);
                        visited.add(next);
                    }
                }

            }
            time++;
        }
        return -1;
    }
}
