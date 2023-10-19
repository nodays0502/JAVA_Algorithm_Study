package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2238 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int u = stoi.apply(st.nextToken());
        int n = stoi.apply(st.nextToken());
        int[] price = new int[u+1];
        String[] name = new String[u+1];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            String nowName = st.nextToken();
            int nowPrice = stoi.apply(st.nextToken());
            if(price[nowPrice] == 0){
                name[nowPrice] = nowName;
            }
            price[nowPrice]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1,v2)->{
            if(price[v1] == price[v2]){
                return v1 - v2;
            }
            return price[v1] - price[v2];
        });
        for(int i = 0 ; i <= u ; i++){
            if(price[i] == 0){
                continue;
            }
            pq.offer(i);
        }
        int lowPrice = pq.poll();

        System.out.println(name[lowPrice]+" "+lowPrice);
    }
}
