package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_20055 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int size = 2*n;
        int[] durability = new int[size];
        boolean[] robot = new boolean[size];
        st = new StringTokenizer(br.readLine()," ");
        int zeroCnt = 0;
        for(int i = 0 ; i < size ; i++){
            durability[i] = stoi.apply(st.nextToken());
            if(durability[i] == 0){
                zeroCnt++;
            }
        }
        int startIndex = 0;
        int endIndex = n-1;
        int step = 0;
        while(zeroCnt < k){

            step++;
            // step 1
            startIndex = (startIndex + size - 1) % (size);
            endIndex = (endIndex + size - 1) % (size);
//            System.out.println(startIndex +" "+endIndex);
//            System.out.println(Arrays.toString(robot));
//            System.out.println(Arrays.toString(durability));
            robot[endIndex] = false;
            // step2
            int nowIndex = endIndex;
            for(int i = 0 ; i < n-1 ; i++){
                int prev = nowIndex;
                nowIndex = (nowIndex + size - 1) % (size);
                if(robot[nowIndex] && durability[prev] != 0 && !robot[prev]){
                    robot[nowIndex] = false;
                    durability[prev]--;
                    if(prev != endIndex){
                        robot[prev] = true;
                    }
                    if(durability[prev] == 0){
                        zeroCnt++;
                    }
//                    if(prev == endIndex){
//                        robot[prev] = false;
//                    }
                }
            }
            // step3
            if(durability[startIndex] != 0){
                durability[startIndex]--;
                robot[startIndex] = true;
                if(durability[startIndex] == 0){
                    zeroCnt++;
                }
            }
        }
        System.out.println(step);
    }
}
