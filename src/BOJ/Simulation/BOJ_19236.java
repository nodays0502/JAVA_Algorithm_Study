package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_19236 {
    private static final int SIZE = 4;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Function<String,Integer> stoi = Integer::parseInt;

        int[][] number = new int[SIZE][SIZE];
        int[][] fishDir = new int[SIZE][SIZE];

        for(int i = 0 ; i < SIZE ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < SIZE ; j++){
                int a = stoi.apply(st.nextToken());
                int b = stoi.apply(st.nextToken())-1;
                number[i][j] = a;
                fishDir[i][j] = b;
            }
        }
        System.out.println(dfs(0,0,number,fishDir));
    }
    private static final int[] dy = {-1,-1,0,1,1,1,0,-1};
    private static final int[] dx = {0,-1,-1,-1,0,1,1,1};
    private static final int SHARK = 99;
    private static int dfs(int y, int x, int[][] number, int[][] fishDir){
        int result = number[y][x];
        number[y][x] = SHARK;

        for(int num = 1 ; num <= SIZE * SIZE ; num++){
            findNum(num,number,fishDir);
//            print(number);
        }

        int dir = fishDir[y][x];
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        number[y][x] = 0;

        int temp = 0;
        while(ny >= 0 && ny < SIZE && nx >= 0 && nx < SIZE){
            if(number[ny][nx] != 0){
                int[][] tempNumber = copyArr(number);
                int[][] tempDir = copyArr(fishDir);
                temp = Math.max(temp, dfs(ny,nx,tempNumber,tempDir));
            }
            ny += dy[dir];
            nx += dx[dir];
        }
        return result + temp;
    }
    private static void findNum(int num,int[][]number, int[][]fishDir){
        for(int i = 0 ; i < SIZE ; i++){
            for(int j = 0 ; j < SIZE ; j++){
                if(number[i][j] == num){
                    moveFish(i,j,number,fishDir);
                    return ;
                }
            }
        }
    }
    private static void moveFish(int y, int x, int[][] number, int[][] fishDir) {
        int dir = fishDir[y][x];
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        while( ny < 0 || ny >= SIZE || nx < 0 || nx >= SIZE || number[ny][nx] == SHARK ){
            dir = (dir + 1) % 8;
            if(dir == fishDir[y][x]){
                return ;
            }
            ny = y + dy[dir];
            nx = x + dx[dir];
        }
        swap(y,x,dir,ny,nx,number,fishDir);

    }

    private static void swap(int y, int x, int dir,int ny, int nx, int[][] number, int[][] fishDir) {
        int tempNum = number[y][x];

        number[y][x] = number[ny][nx];
        fishDir[y][x] = fishDir[ny][nx];

        number[ny][nx] = tempNum;
        fishDir[ny][nx] = dir;
    }

    private static int[][] copyArr(int[][] arr){
        int[][] temp = new int[SIZE][SIZE];
        for(int i = 0 ; i < SIZE ; i++){
            for(int j = 0 ; j < SIZE ; j++){
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }
    private static void print(int[][] arr){
        for(int i = 0 ; i < SIZE ; i++){
            for(int j = 0 ; j < SIZE ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
