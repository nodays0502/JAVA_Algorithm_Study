package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10845 {
    private static final int EMPTY = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            if("push".equals(command)){
                int num = stoi.apply(st.nextToken());
                q.offerLast(num);
                continue;
            }
            if("pop".equals(command)){
                if(q.isEmpty()){
                    System.out.println(EMPTY);
                }else{
                    System.out.println(q.poll());
                }
                continue;
            }
            if("size".equals(command)){
                System.out.println(q.size());
                continue;
            }
            if("empty".equals(command)){
                if(q.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
                continue;
            }
            if("front".equals(command)){
                if(q.isEmpty()){
                    System.out.println(EMPTY);
                }else{
                    System.out.println(q.peek());
                }
                continue;
            }
            if("back".equals(command)){
                if(q.isEmpty()){
                    System.out.println(EMPTY);
                }else{
                    System.out.println(q.peekLast());
                }
                continue;
            }
        }
    }
}
