package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_25195 {
    private static final int START_POSITION = 1;
    private static final String SHOULD_MEET = "Yes";
    private static final String HAVE_CANT_MEET = "yes";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] list = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            list[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int start = stoi.apply(st.nextToken());
            int end = stoi.apply(st.nextToken());
            list[start].add(end);
        }

        boolean[] isFan = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        int s = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < s ; i++){
            int position = stoi.apply(st.nextToken());
            isFan[position] = true;
        }
        boolean result = cantMeetFan(START_POSITION,isFan,list);
        if(!result){
            System.out.println(SHOULD_MEET);
        }else{
            System.out.println(HAVE_CANT_MEET);
        }
    }

    private static boolean cantMeetFan(int position, boolean[] isFan, List<Integer>[] list) {
        if(isFan[position]){
            return false;
        }
        boolean result = false;
        if(list[position].size() == 0){
            return true;
        }
        for(int next : list[position]){
            if(cantMeetFan(next,isFan,list)){
                result = true;
            }
        }
        return result;
    }
}
