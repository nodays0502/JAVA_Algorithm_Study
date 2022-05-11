package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14500 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        List<int[][]> specialCase = new ArrayList<>();
        specialCase.add(special);
        int[][] prev = special;
        for(int i = 0 ; i < 3; i++){
            int[][] temp = rotation(prev);
            specialCase.add(temp);
            prev = temp;
        }
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                result = Math.max(result,dfs(0,i,j,map,n,m,-1));
                result = Math.max(result,calSpecial(i,j,map,specialCase,n,m));
            }
        }

//        System.out.println(specialCase.size());
//        for(int[][] arr : specialCase){
//            System.out.println(Arrays.deepToString(arr));
//        }
        System.out.println(result);
    }
    private static int calSpecial(int y, int x, int[][] map, List<int[][]> specialCase,int n,int m){
        int result = 0;
        for(int k = 0 ; k < specialCase.size() ; k++){
            int[][] arr = specialCase.get(k);
            int arrN = arr.length;
            int arrM = arr[0].length;
//            System.out.println(Arrays.deepToString(arr)+" "+arrN+" "+arrM+" "+(y + arrN)+" "+(x + arrM) ) ;
            if(y + arrN > n || x + arrM > m){
                continue;
            }
            int sum = 0;
            for(int i = 0 ; i < arrN ; i++){
                for(int j = 0 ; j < arrM ; j++){
                    sum += map[y + i][x + j] * arr[i][j];
                }
            }

            result = Math.max(result, sum);
        }
        return result;
    }
    private static final int[][] special = {{1,1,1,},{0,1,0}};
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static int[][] rotation(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int [][] temp = new int[m][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                temp[m-1-j][i] = arr[i][j];
            }
        }
        return temp;
    }
    private static int dfs(int depth, int y, int x, int[][] map, int n, int m,int dir) {
        if(depth == 4){
            return 0;
        }
        int result = 0;
        for(int i = 0 ; i < 4; i++){
            if(dir == i){
                continue;
            }
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                int nowDir = (i + 2) % 4;
                result = Math.max(result, dfs(depth+1,ny,nx,map,n,m,nowDir));
            }
        }
        return result + map[y][x];
    }
}
