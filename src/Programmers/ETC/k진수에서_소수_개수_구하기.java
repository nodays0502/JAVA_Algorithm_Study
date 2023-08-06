package Programmers.ETC;

public class k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        String s = changeString(n,k);
        int answer = countPrime(s);
        return answer;
    }
    private static String changeString(int n ,int k){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n % k);
            n /= k;
        }
        sb = sb.reverse();
        return sb.toString();
    }
    private static int countPrime(String s){
        String[] strArr = s.split("0");
        int result = 0;
        for(String str : strArr){
            if(str.equals("") || str == null){
                continue;
            }
            if(isPrime(Long.parseLong(str))){
                result++;
            }
        }
        return result;
    }
    private static boolean isPrime(long num){
        if(num == 1){
            return false;
        }
        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
