package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1213 {
    private static final int SIZE = 26;
    private static final String FAIL = "I'm Sorry Hansoo";
    private static final char EMPTY = '5';
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        int[] cnt = new int[SIZE];
        int totalCnt = 0;
        for(int i = 0 ; i < command.length() ; i++){
            char ch = command.charAt(i);
            cnt[ch - 'A']++;
            totalCnt++;
        }
        String result = cal(command,cnt,totalCnt);
        System.out.println(result);
    }

    private static String cal(String command, int[] cnt, int totalCnt) {
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        char temp = EMPTY;
        boolean haveOdd = false;
        for(int i = 0 ; i < SIZE ; i ++){
            if(haveOdd && cnt[i] % 2 != 0){
                return FAIL;
            }
            if(cnt[i] % 2 != 0){
                haveOdd = true;
            }

        }
        for(int i = 0 ; i < SIZE ; i ++){
            while(cnt[i] >= 2){
                front.append((char)('A'+i));
                back.append((char)('A'+i));
                cnt[i] -= 2;
                totalCnt -= 2;
            }
            if(cnt[i] == 1){
                temp = (char)('A' + i);
            }
        }
        if(temp != EMPTY){
            front.append(temp);
        }
        String result = front.toString() + back.reverse().toString();
        return result;
    }
}
