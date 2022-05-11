package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1963 {

    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        boolean[] isPrime = new boolean[10_000];
        for(int i = 1_000; i < 10_000 ; i++){
            isPrime[i] = checkPrime(i);
        }
        for(int t = 0 ; t < test ; t++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int result = bfs(a,b,isPrime);
            if(result == -1){
                System.out.println("Impossible");
            }else{
                System.out.println(result);
            }

        }
    }

    private static boolean checkPrime(int num) {
        for(int i = 2 ; i <= Math.sqrt(num); i++){
            if(num % i== 0){
                return false;
            }
        }
        return true;
    }

    private static int bfs(int a, int b, boolean[] isPrime) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[10_000];
        int time = 0;
        q.offer(a);
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size; s++){
                int now = q.poll();
//                System.out.println(time+" "+now);
                if(now == b){
                    return time;
                }
                for(int i = 10 ; i < 100_000 ; i*=10){
                    for(int j = 0 ; j < 10 ; j++){
                        int temp = (now / i) * i;
                        if(i >= 100){
                            temp += (now % (i / 10));
                        }
                        temp += j * i/10;
                        if(temp < 10_000 && isPrime[temp] && !visited[temp]){
                            visited[temp] = true;
                            q.offer(temp);
                        }
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
