package Programmers.ETC;

public class 시저_암호 {
    public String solution(String s, int n) {
        String answer= cal(s,n);


        return answer;
    }
    private static String cal(String s, int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            char now = s.charAt(i);
            char nextCh = moveCh(now,n);
            sb.append(nextCh);
        }
        return sb.toString();
    }
    private static final int ALPHA_SIZE = 26;
    private static char moveCh(char ch , int n){
        if( !( (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') )  ){
            return ch;
        }
        // n %= ALPHA_SIZE;
        char nextCh = (char)(ch + n);
        if(ch >= 'a' && ch <= 'z' && (nextCh < 'a' || nextCh > 'z') ){
            int diff = nextCh - 'z'-1;
            nextCh = (char)(diff + 'a');
        }
        if(ch >= 'A' && ch <= 'Z' && (nextCh < 'A' || nextCh > 'Z') ){
            int diff = nextCh - 'Z'-1;
            nextCh = (char)(diff + 'A');
        }
        return nextCh;
    }
}
