package BOJ.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1275 {
    private static void update(int index , int number,int n ,long[] tree){
        while(index <= n){
            tree[index] += number;
            index += (index & -index);
        }
    }
    private static long sum(int index ,long[] tree){
        long result = 0;
        while(index > 0){
            result += tree[index];
            index -= (index & -index);
        }
        return result;
    }
    private static long getSection(int start, int end, long[] tree){
        return sum(end,tree) - sum(start-1,tree);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int q = stoi.apply(st.nextToken());
        int[] input = new int[n+1];
        long[] tree = new long[n+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1 ; i <= n ; i++){
            int num = stoi.apply(st.nextToken());
            input[i] = num;
            update(i,num,n,tree);
        }
        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int y = stoi.apply(st.nextToken());
            int x = stoi.apply(st.nextToken());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            System.out.println(getSection(Math.min(y,x),Math.max(y,x),tree));
            update(a,b - input[a],n,tree);
            input[a] = b;
        }
    }
}
