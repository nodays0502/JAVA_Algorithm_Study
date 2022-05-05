package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15662 {

    private static final int RIGHT = 2;
    private static final int LEFT = 6;
    private static final int TOP = 0;
    private static final int N = 0;
    private static final int S = 1;
    private static final int CLOCK_DIR = 1;
    private static final int REVERSE_CLOCK_DIR = -1;
    private static final int REVERSE_DIR = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int size = stoi.apply(st.nextToken());
        LinkedList<Integer>[] input = new LinkedList[size];
        for(int i = 0 ; i < size;  i++){
            String command = br.readLine();
            input[i] = new LinkedList<>();
            for(int j = 0 ; j < 8 ; j++){
                input[i].offerLast(stoi.apply(command.charAt(j)+""));
            }
        }
        int rotationCnt = stoi.apply(br.readLine());
        for(int i = 0 ; i < rotationCnt ; i++){
            boolean[] visited = new boolean[size];
            st = new StringTokenizer(br.readLine()," ");
            int wheelNum = stoi.apply(st.nextToken())-1;
            int type = stoi.apply(st.nextToken());
            switchWheel(input,wheelNum,type,size,visited);
        }
        int result = 0;
        for(int i = 0 ; i < size ; i++){
            if(input[i].get(TOP) == S){
                result++;
            }
        }
        System.out.println(result);
    }

    private static void switchWheel(LinkedList<Integer>[] input, int wheelNum, int type,int size,boolean[] visited) {
        visited[wheelNum] = true;
        int prevWheelNum = wheelNum - 1;
        int nextWheelNum = wheelNum + 1;
        if(prevWheelNum >= 0 && !visited[prevWheelNum] && input[wheelNum].get(LEFT) != input[prevWheelNum].get(RIGHT) ){
            switchWheel(input,prevWheelNum,REVERSE_DIR * type,size,visited);
        }
        if(nextWheelNum < size && !visited[nextWheelNum] && input[wheelNum].get(RIGHT) != input[nextWheelNum].get(LEFT)){
            switchWheel(input,nextWheelNum,REVERSE_DIR * type,size,visited);
        }
        turnWheel(input[wheelNum],type);
    }

    private static void turnWheel(LinkedList<Integer> input,int type){
        if(type == CLOCK_DIR){
            input.offerFirst(input.pollLast());
            return ;
        }
        if(type == REVERSE_CLOCK_DIR){
            input.offerLast(input.pollFirst());
            return;
        }
    }
}
