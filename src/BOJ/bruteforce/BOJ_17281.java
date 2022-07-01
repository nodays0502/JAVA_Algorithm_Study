package BOJ.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17281 {
    private static final int PEOPLE_SIZE = 9;
    private static final int MAX_OUT_CNT = 3;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] input = new int[n][PEOPLE_SIZE];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < PEOPLE_SIZE ; j++){
                input[i][j] = stoi.apply(st.nextToken());
            }
        }
        boolean[] isSelected = new boolean[PEOPLE_SIZE];
        int[] order = new int[PEOPLE_SIZE];
        order[3] = 0;
        isSelected[0] = true;
        int answer = dfs(0,isSelected,order,n,input);
        System.out.println(answer);
    }

    private static int dfs(int depth, boolean[] isSelected, int[] order, int n, int[][] input) {
        if(depth == PEOPLE_SIZE){
            return calScore(order,n,input);
        }
        if(depth == 3){
            return dfs(depth+1,isSelected,order,n,input);
        }
        int result = 0;
        for(int i = 1 ; i < PEOPLE_SIZE ; i++){
            if(!isSelected[i]){
                isSelected[i] = true;
                order[depth] = i;
                result = Math.max(result,dfs(depth+1,isSelected,order,n,input));
                isSelected[i] = false;
            }
        }
        return result;
    }

    private static int calScore(int[] order, int n, int[][] input) {
        int nowIndex = 0;
        int score = 0;
        for(int i = 0 ; i < n ; i++){
            boolean[] position = new boolean[4]; // 1 2 3
            int outCnt = 0;
            while(outCnt < MAX_OUT_CNT){
                position[0] = true;
                if(nowIndex == PEOPLE_SIZE){
                    nowIndex = 0;
                }
                int now = order[nowIndex++];
                int kind = input[i][now];
                if(kind == 0){
                    outCnt++;
                    continue;
                }
                for(int j = 3; j >= 0 ; j--){
                    if(position[j] == true){
                        position[j] = false;
                        if(j + kind >= 4){
                            score++;
                        }else{
                            position[j+kind] = true;
                        }
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(order) +" "+score);
        return score;
    }

}
