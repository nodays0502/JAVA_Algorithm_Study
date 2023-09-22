package Programmers.ETC;

public class 수_조작하기2 {
    private static final int[] DIFF = {1,-1,10,-10};
    private static final char[] SIGN = {'w', 's' , 'd' ,'a'};
    public String solution(int[] numLog) {
        String answer = "";
        int size = numLog.length;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < size ; i++){
            int index = 0;
            for(int j = 0 ; j < 4; j++){
                if(numLog[i] - numLog[i-1] == DIFF[j]){
                    index = j;
                    break;
                }
            }
            sb.append(SIGN[index]);
        }
        answer = sb.toString();
        return answer;
    }
}
