package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_22233 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            String word = br.readLine();
            set.add(word);
        }
        for(int i = 0 ; i < m ; i++){
            String[] words = br.readLine().split(",");
            for(String word : words){
                set.remove(word);
            }
            System.out.println(set.size());
        }

    }
}
