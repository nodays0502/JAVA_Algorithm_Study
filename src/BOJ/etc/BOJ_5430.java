package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_5430 {
    private static final Function<String,Integer> stoi = Integer::parseInt;
    private static final String ERROR = "error";
    private static final char R = 'R';
    private static final char D = 'D';
    private static final String SEPARATOR = ",";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = stoi.apply(br.readLine());
        for(int t = 0 ; t < testCnt ; t++){
            String command = br.readLine();
            int n = stoi.apply(br.readLine());
            String arrStr = br.readLine();
            int[] arr = detectArr(arrStr,n);
            cal(arr,n,command);
        }
    }

    private static void cal(int[] arr, int n, String command) {
        int dCnt = 0;
        for(int i = 0 ; i < command.length(); i++){
            if(command.charAt(i) == D){
                dCnt++;
            }
        }
        if(dCnt > n){
            System.out.println(ERROR);
            return;
        }
        int startIndex = 0;
        int endIndex = n-1;
        boolean forwardDir = true;
        for(int i = 0 ; i < command.length(); i++){
            if(command.charAt(i) == R){
                forwardDir = !forwardDir;
            }else{ // D
                if(forwardDir){
                    startIndex++;
                }else{
                    endIndex--;
                }
            }
        }
        printArr(arr,startIndex,endIndex,forwardDir);
    }

    private static void printArr(int[] arr, int startIndex, int endIndex,boolean forwardDir) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(forwardDir){
            for(int i = startIndex ; i <= endIndex ; i++){
                sb.append(arr[i]+SEPARATOR);
            }
        }else{
            for(int i = endIndex ; i >= startIndex ; i--){
                sb.append(arr[i]+SEPARATOR);
            }
        }
        if(startIndex <= endIndex){ // 빈 배열인 경우를 제외
            sb.setLength(sb.length()-1); // 마지막 ',' 지우기
        }
        sb.append("]");
        System.out.println(sb);
    }

    private static int[] detectArr(String arrStr,int n) {
        arrStr = arrStr.substring(1, arrStr.length()-1); // 입력의 '[',']' 제거
        int[] result = new int[n];
        String[] temp = arrStr.split(SEPARATOR);
        for(int i = 0 ; i < n ; i++){
            result[i] = stoi.apply(temp[i]);
        }
        return result;
    }
}
