package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2290 {

    private static final char[][][] NUMBER = new char[][][] {
        { // 0
            {' ','-',' '},
            {'|',' ','|'},
            {' ',' ',' '},
            {'|',' ','|'},
            {' ','-',' '}
        },
        { // 1
            {' ',' ',' '},
            {' ',' ','|'},
            {' ',' ',' '},
            {' ',' ','|'},
            {' ',' ',' '}
        },
        { // 2
            {' ','-',' '},
            {' ',' ','|'},
            {' ','-',' '},
            {'|',' ',' '},
            {' ','-',' '}
        },
        { // 3
            {' ','-',' '},
            {' ',' ','|'},
            {' ','-',' '},
            {' ',' ','|'},
            {' ','-',' '}
        },
        { // 4
            {' ',' ',' '},
            {'|',' ','|'},
            {' ','-',' '},
            {' ',' ','|'},
            {' ',' ',' '}
        },
        { // 5
            {' ','-',' '},
            {'|',' ',' '},
            {' ','-',' '},
            {' ',' ','|'},
            {' ','-',' '}
        },
        { // 6
            {' ','-',' '},
            {'|',' ',' '},
            {' ','-',' '},
            {'|',' ','|'},
            {' ','-',' '}
        },
        { // 7
            {' ','-',' '},
            {' ',' ','|'},
            {' ',' ',' '},
            {' ',' ','|'},
            {' ',' ',' '}
        },
        { // 8
            {' ','-',' '},
            {'|',' ','|'},
            {' ','-',' '},
            {'|',' ','|'},
            {' ','-',' '}
        },
        { // 9
            {' ','-',' '},
            {'|',' ','|'},
            {' ','-',' '},
            {' ',' ','|'},
            {' ','-',' '}
        },
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        String number = st.nextToken();
        makeLCD(number,s);
    }

    private static void makeLCD(String number, int s) {
        int n = 5;
        StringBuilder[] result = new StringBuilder[n];
        for(int i = 0  ; i < n ; i++){
            result[i] = new StringBuilder();
        }
        int index = 0;
        for(int i = 0 ; i < number.length() ; i++){
            int now = number.charAt(i) - '0';
            fillResult(result,now,s,n);
        }
        for(int i = 0  ; i < n ; i++){
            if(i == 1 || i == 3){
                for(int j = 0 ; j < s; j++){
                    System.out.println(result[i]);
                }
                continue;
            }
            System.out.println(result[i]);
        }
    }

    private static void fillResult(StringBuilder[] result, int now, int s, int n) {
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                result[i].append(NUMBER[now][i][j]);
                if(j == 1){ // 중간 것은 개수만큼 추가
                    for(int k = 0 ; k < s - 1; k++){
                        result[i].append(NUMBER[now][i][j]);
                    }
                }
            }
        }
        for(int i = 0 ; i < 5 ; i++){
            result[i].append(' ');
        }
    }


}