package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15684 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int h = stoi.apply(st.nextToken());
        int[][] map = new int[h][n];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken())-1;
            int b = stoi.apply(st.nextToken())-1;
            map[a][b] = 1;
            map[a][b+1] = -1;
        }
        int result = -1;
        for(int i = 0 ; i <= 3; i++){
            if(dfs(i,map,n,h,0)){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    private static boolean dfs(int depth, int[][] map, int n, int h, int start) {
        if(depth == 0){
            for(int i = 0 ; i < n ; i++){
                if(!moveDown(map,i,n,h)){
                    return false;
                }
            }
            return true;
        }
        int row = start / n;
        int col = start % n;
        for(int i = row ; i < h ; i++){
            for(int j = 0 ; j < n-1 ; j++){
                if(map[i][j] == 0 && map[i][j+1] == 0){
                    map[i][j] = 1;
                    map[i][j+1] = -1;
                    if(dfs(depth-1,map,n,h,n*i + j + 1)){
                        return true;
                    }
                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }
        }
        return false;
    }

    private static boolean moveDown(int[][]map, int index,int n, int h){
        int now = index;
        for(int i = 0 ; i < h ; i++){
            now += map[i][now];
        }
        if(index == now){
            return true;
        }else{
            return false;
        }
    }
}
