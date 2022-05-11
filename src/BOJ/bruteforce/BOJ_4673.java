package BOJ.bruteforce;

public class BOJ_4673 {
    static final int SIZE = 10_000;
    private static void checkSelfNumber(int number, boolean[] selfNumber){
        int sum = number;
        while(number > 0){
            sum += (number % 10);
            number /= 10;
        }
        if(sum <= SIZE){
            selfNumber[sum] = true;
        }
    }
    public static void main(String[] args) {
        boolean[] selfNumber = new boolean[SIZE+1];
        for(int i = 1; i <= SIZE; i++){
            checkSelfNumber(i,selfNumber);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= SIZE; i++){
            if(!selfNumber[i]){
                sb.append(i+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
