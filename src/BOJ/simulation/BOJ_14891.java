package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.function.Function;

public class BOJ_14891 {
    private static final int TOP = 0;
    private static final int RIGHT = 2;
    private static final int LEFT = 6;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        LinkedList<Integer>[] list = new LinkedList[4];
        for(int i = 0 ; i < 4 ; i++){
            list[i] = new LinkedList<>();
            String command = br.readLine();
            for(int j = 0 ; j < 8 ; j++){
                int now = command.charAt(j)-'0';
                list[i].offerLast(now);
            }
        }
        int m = stoi.apply(br.readLine());
        for(int i = 0 ; i < m ; i++){
            boolean[] visited = new boolean[4];
            String[] command = br.readLine().split(" ");
            int location = stoi.apply(command[0])-1;
            int dir = stoi.apply(command[1]);
            rotation(location,dir,list,visited);
        }
        int result = 0;
        for(int i = 0 ; i < 4 ; i++){
//            System.out.println(list[i]);
            if(list[i].get(TOP) == 1){
                if(i == 0){
                    result += 1;
                }else if(i == 1){
                    result += 2;
                }else if(i == 2){
                    result += 4;
                }else if(i == 3){
                    result += 8;
                }
            }
        }
        System.out.println(result);
    }
    private static void rotation(int location, int dir , LinkedList<Integer>[] list,boolean[] visited){
        LinkedList<Integer> nowList = list[location];
        visited[location] = true;
        if(location + 1 < 4 && !visited[location + 1] && nowList.get(RIGHT) != list[location + 1].get(LEFT)){
            rotation(location+1,-dir,list,visited);
        }
        if(location - 1 >= 0 && !visited[location - 1] && nowList.get(LEFT) != list[location - 1].get(RIGHT)){
            rotation(location-1,-dir,list,visited);
        }
        if(dir == 1){
            int last = nowList.pollLast();
            nowList.offerFirst(last);
        }else{
            int first = nowList.pollFirst();
            nowList.offerLast(first);
        }
    }
}
