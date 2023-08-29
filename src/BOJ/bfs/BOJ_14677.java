package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BOJ_14677 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String command = br.readLine();
        int size = 3*n;
        int result = bfs(command,size);
        System.out.println(result);
    }
    private static final char[] DRUG_TYPE = {'B','L','D'};
    private static int bfs(String command, int size) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,size-1});
        int time = -1;
        Set<String> visited = new HashSet<>();
        while(!q.isEmpty()){
            time++;
            int qSize = q.size();
            int nowDrugType = DRUG_TYPE[time % 3];
            for(int s = 0 ; s < qSize ; s++){
                int[] now = q.poll();
//                System.out.println(time+" "+Arrays.toString(now));
                if(now[0] > now[1]){
                    continue;
                }
                if(command.charAt(now[0]) == nowDrugType){
                    int[] next = new int[]{now[0]+1,now[1]};
                    if(!visited.contains(Arrays.toString(next))){
                        visited.add(Arrays.toString(next));
                        q.offer(next);
                    }
                }
                if(command.charAt(now[1]) == nowDrugType){
                    int[] next = new int[]{now[0],now[1]-1};
                    if(!visited.contains(Arrays.toString(next))){
                        visited.add(Arrays.toString(next));
                        q.offer(next);
                    }
                }
            }
            if(time >= size){
                break;
            }
        }
        return time;
    }
}
