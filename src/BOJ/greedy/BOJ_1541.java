package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_1541 {
    private static final int NOT_VALID = 987654321;
    private static final String PLUS = "\\+";
    private static final String MINUS = "-";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        String[] deleteMinus = command.split(MINUS);
        int result = NOT_VALID;
        Function<String,Integer> stoi = Integer::parseInt;
        for(String s : deleteMinus){
            int sum = 0;
            String[] temps = s.split(PLUS);
            sum += Arrays.stream(temps).mapToInt(i -> stoi.apply(i)).sum();
            if(result == NOT_VALID){
                result = sum;
            }else{
                result -= sum;
            }
        }
        System.out.println(result);
    }
}
