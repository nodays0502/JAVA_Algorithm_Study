package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1124 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[2];
        for (int i = 0; i < 2; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        List<Integer> prime = makePrimeNumber(input[1]);
        for (int i = input[0]; i <= input[1]; i++) {
            if (isCntPrime(i,prime)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static List<Integer> makePrimeNumber(int number) {
        List<Integer>list = new LinkedList<>();
        for(int i = 2; i <= number; i++){
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isCntPrime(int number, List<Integer> prime) {
        int cnt = 0;
        for(int num : prime){
            if(number < num){
                break;
            }
            while (number % num == 0) {
                number /= num;
                cnt++;
            }
        }
        return isPrime(cnt);
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
