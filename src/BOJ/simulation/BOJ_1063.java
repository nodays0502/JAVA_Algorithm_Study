package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1063 {
    private static final char[] col = {'A','B','C','D','E','F','G','H'};
    private static final String[] DIR = {"T","R","B","L","RT","RB","LB","LT"};
    private static final int[] DY = {1,0,-1,0,1,-1,-1,1};
    private static final int[] DX = {0,1,0,-1,1,1,-1,-1};
    private static final int SIZE = 8;
    private static Function<String,Integer> stoi = Integer::parseInt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] king = getPosition(st.nextToken());
        int[] block = getPosition(st.nextToken());
        int n = stoi.apply(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            int index = 0;
            for(int j = 0 ; j < 8 ; j++){
                if(command.equals(DIR[j])){
                    index = j;
                    break;
                }
            }
            int ny = king[0] + DY[index];
            int nx = king[1] + DX[index];
            if(!checkBound(ny,nx)){
                continue;
            }
            if(block[0] == ny && block[1] == nx){
                int bny = block[0] + DY[index];
                int bnx = block[1] + DX[index];
                if(!checkBound(bny,bnx)){
                    continue;
                }
                block = new int[] {bny,bnx};
                king = new int[] {ny,nx};
                continue;
            }
            king = new int[]{ny,nx};
        }
        StringBuilder sb = new StringBuilder();
        sb.append( (char)(king[1]+'A'-1) );
        sb.append(king[0]);
        sb.append('\n');
        sb.append( (char)(block[1]+'A'-1) );
        sb.append(block[0]);
        System.out.println(sb.toString());
    }

    private static int[] getPosition(String position) {
        int y = stoi.apply(position.charAt(1)+"");
        int x = position.charAt(0) - 'A' + 1;
        return new int[] {y,x};
    }
    private static boolean checkBound(int y, int x){
        if(y >= 1 && y <= SIZE && x >= 1 && x <= SIZE){
            return true;
        }else{
            return false;
        }
    }
}
