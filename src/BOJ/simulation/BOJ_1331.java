package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1331 {
    private static final int SIZE = 6;
    private static final String VALID = "Valid";
    private static final String INVALID = "Invalid";
    private static final int INPUT_SIZE = 36;
    private static final int[] DY = {-2,-1,1,2,2,1,-1,-2};
    private static final int[] DX = {1,2,2,1,-1,-2,-2,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] visited = new boolean[SIZE][SIZE];
        int[] prev = new int[2];
        int[] start = new int[2];
        boolean result = true;
        for(int i = 0 ; i < INPUT_SIZE ; i++){
            int[] position = getPosition(br.readLine());
            if(visited[position[0]][position[1]]){
                result = false;
                break;
            }
            if(i == 0){
                start = position;
            }
            if(i != 0 && !checkMove(prev,position)){
                result = false;
                break;
            }
            visited[position[0]][position[1]] = true;
            prev = position;

        }
        if (result && checkMove(prev,start)){
            System.out.println(VALID);
        }else{
            System.out.println(INVALID);
        }
    }
    private static int[] getPosition(String str){
        int first = str.charAt(0) - 'A';
        int second = str.charAt(1) - '1';
        return new int[] {first,second};
    }
    private static final boolean checkMove(int[] prev, int[] next){
        for(int j = 0 ; j < 8 ; j++){
            int ny = prev[0] + DY[j];
            int nx = prev[1] + DX[j];
            if(ny == next[0] && nx == next[1]){
                return true;
            }
        }
        return false;
    }
}
