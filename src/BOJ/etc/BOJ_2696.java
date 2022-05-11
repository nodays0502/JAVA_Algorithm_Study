package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2696 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for(int t= 0 ; t < test ; t++){
            PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> max = new PriorityQueue<>();
            int n = stoi.apply(br.readLine());
            System.out.println(n/2 + n%2);
            int[] input = new int[n];
            for(int i = 0 ; i <= n / 10 ; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0 ; j < 10 && 10 * i + j < n ; j++){
                    int num = stoi.apply(st.nextToken());
                    if(min.size() == 0){
                        min.offer(num);
                        System.out.print(num+" ");
                        continue;
                    }
                    if(min.peek() < num){
                        max.offer(num);
                    }else{
                        min.offer(num);
                    }
                    if(j % 2 == 0){
                        while(min.size() - 1 != max.size()){
//                            System.out.println(min.size()+" "+max.size());
                            if(min.size() - 1 > max.size()){
                                max.offer(min.poll());
                            }else{
                                min.offer(max.poll());
                            }
                        }
                        System.out.print(min.peek()+" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
