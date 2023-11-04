package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
    public class Test {
        private static final int EMPTY = 0;
        private static final int BLOCK = 1;
        public void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] height = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < m ; i++){
                height[i] = Integer.parseInt(st.nextToken());
            }
            int result = 0;
            for(int i = 1 ; i <= n ; i++){
                int prevIndex = -1;
                for(int j = 0 ; j < m ; j++){
                    if(height[j] < i){
                        continue;
                    }
                    if(prevIndex != -1){
                        result += j - prevIndex - 1;
                    }
                    prevIndex = j;
                }
            }
            System.out.println(result);
        }

    }
}
