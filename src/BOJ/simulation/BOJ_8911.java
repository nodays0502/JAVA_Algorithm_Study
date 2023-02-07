package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8911 {
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char FRONT = 'F';
    private static final char BACK = 'B';
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < testCnt ; t++){
            String command = br.readLine();
            cal(command);
        }
    }
    private static final int SIZE = 500;
    private static void cal(String command) {
        int dir = 0;
        int y = SIZE;
        int x = SIZE;
        int minY = SIZE;
        int maxY = SIZE;
        int minX = SIZE;
        int maxX = SIZE;
        for(int i = 0 ; i < command.length() ; i++){
            char ch = command.charAt(i);
            if(FRONT == ch){
                y += DY[dir];
                x += DX[dir];
            }else if(BACK == ch){
                y -= DY[dir];
                x -= DX[dir];
            }else if(LEFT == ch){
                dir = (dir+3) % 4;
            }else{
                dir = (dir+1) % 4;
            }
            minY = Math.min(minY,y);
            minX = Math.min(minX,x);
            maxY = Math.max(maxY,y);
            maxX = Math.max(maxX,x);
        }
        System.out.println((maxY-minY) * (maxX - minX));
    }

}
