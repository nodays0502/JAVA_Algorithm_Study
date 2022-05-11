package BOJ.implement;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13567 {
    private static final int FAIL = -1;

    private static final int TURN_LEFT = 0;
    private static final int TURN_RIGHT = 1;

    private static final int TURN_LEFT_COEFFICIENT = 3;
    private static final int TURN_RIGHT_COEFFICIENT = 1;

    private static final int[] dy = {1,0,-1,0};
    private static final int[] dx = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int sqrSize = stoi.apply(st.nextToken());
        int commandLine = stoi.apply(st.nextToken());
        int y = 0;
        int x = 0;
        int dir = 1;
        for(int i = 0 ; i < commandLine ; i++){
            st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            int number = stoi.apply(st.nextToken());
//            System.out.println(y+" "+x+" "+dir);
//            System.out.println(command +" "+number);
            int[] result = doCommand(y,x,dir,sqrSize,command,number);
            if(result == null){
                System.out.println(FAIL);
                return;
            }
            y = result[0];
            x = result[1];
            dir = result[2];
        }
        System.out.println(x+" "+y);
    }

    private static int[] doCommand(int y, int x, int dir,int sqrSize, String command, int number) {
        if("MOVE".equals(command)){
            int ny = y + number * dy[dir];
            int nx = x + number * dx[dir];
            if(checkBound(ny,nx,sqrSize)){
                return new int[] {ny,nx,dir};
            }
            return null;
        }
        if("TURN".equals(command)) {
            if(number == TURN_LEFT){
                dir = (dir + TURN_LEFT_COEFFICIENT) % 4;
            }
            if(number == TURN_RIGHT){
                dir = (dir + TURN_RIGHT_COEFFICIENT) % 4;
            }
            return new int[] {y,x,dir};
        }
        return null;
    }
    private static boolean checkBound(int y , int x , int sqrSize){
        if(y >= 0 && y <= sqrSize && x >= 0 && x <= sqrSize){
            return true;
        }
        return false;
    }
}
