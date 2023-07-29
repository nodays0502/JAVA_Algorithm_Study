package Programmers.ETC;

public class 이진_변환_반복하기 {
    private static final String ONE = "1";
    public int[] solution(String s) {
        int removedZeroCnt = 0;
        int cnt = 0;
        while(!s.equals(ONE)){
            removedZeroCnt += countZero(s);
            s = removeZero(s);
            s = changeLengthToBinary(s);
            cnt++;
        }
        int[] answer = new int[]{cnt,removedZeroCnt};
        return answer;
    }
    private static int countZero(String s){
        int ZeroCnt = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '0'){
                ZeroCnt++;
            }
        }
        return ZeroCnt;
    }
    private static String removeZero(String s){
        int oneCnt = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '1'){
                oneCnt++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < oneCnt ; i++){
            sb.append(1);
        }
        return sb.toString();
    }
    private static String changeLengthToBinary(String s){
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        while(length >= 1){
            sb.append(length % 2);
            length /= 2;
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
