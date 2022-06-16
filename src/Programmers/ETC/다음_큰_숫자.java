package Programmers.ETC;

public class 다음_큰_숫자 {
    public int solution(int n) {
        int answer = 0;
        String binearyNum = changeBinearyNumber(n);
        String nextBinearyNum = nextNumber(binearyNum);
        answer =  changeDeciamlNumber(nextBinearyNum);
        return answer;
    }
    private static final char ONE = '1';
    private static final char ZERO = '0';
    private int changeDeciamlNumber(String s){
        int result = 0;
        int num = 1;
        for(int i = s.length()-1 ; i >= 0  ; i--){
            char now = s.charAt(i);
            if(now == ONE){
                result += num * 1;
            }
            num *= 2;
        }
        return result;
    }
    private String nextNumber(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(ZERO);
        sb.append(s);
        int size = sb.length();
        int index = 0;
        int zeroCnt = 0;
        boolean findOne = false;
        for(int i = size - 1; i >= 0 ; i--){
            char now = sb.charAt(i);
            if(now == ONE && !findOne){
                findOne = true;
                continue;
            }
            if(now == ZERO){
                zeroCnt++;
            }
            if(now == ZERO && findOne){
                index = i;
                break;
            }
        }
        int length = sb.length() - index-1;
        sb.delete(index, sb.length());
        sb.append(ONE);
        for(int i = 0 ; i < length ; i++){
            if(zeroCnt > 0){
                zeroCnt--;
                sb.append(0);
            }else{
                sb.append(1);
            }
        }
        return sb.toString();
    }
    private String changeBinearyNumber(int num){
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            if(num % 2 == 0){
                sb.append(0);
            }else{
                sb.append(1);
            }
            num /= 2;
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
