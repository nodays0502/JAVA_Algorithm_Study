package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1251 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size = str.length();
        String result = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        for (int i = 1 ; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                StringBuilder temp1 = new StringBuilder(str.substring(0, i)).reverse();
                StringBuilder temp2 = new StringBuilder(str.substring(i, j)).reverse();
                StringBuilder temp3 = new StringBuilder(str.substring(j, size)).reverse();

                StringBuilder sb = new StringBuilder(temp1);
                sb.append(temp2);
                sb.append(temp3);
                if (result.compareTo(sb.toString()) > 0) {
                    result = sb.toString();
                }
            }
        }
        System.out.println(result);
    }
}
