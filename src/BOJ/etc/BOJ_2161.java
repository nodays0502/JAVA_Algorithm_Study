package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

public class BOJ_2161 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n ; i++){
            q.offer(i);
        }
        while(true){
            System.out.print(q.poll()+" ");
            if(q.isEmpty()){
                break;
            }
            q.offer(q.poll());
        }
    }
}
