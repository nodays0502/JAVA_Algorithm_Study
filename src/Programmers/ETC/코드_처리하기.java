package Programmers.ETC;

public class 코드_처리하기 {
    private static final String EMPTY = "EMPTY";

    public String solution(String code) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int mode = 0;
        int size = code.length();
        for(int i = 0 ; i < size ; i++){
            char ch = code.charAt(i);
            if(ch == '1'){
                mode = (mode+1)%2;
                continue;
            }
            if(mode == 0 && i % 2 == 0){
                sb.append(ch);
            }
            if(mode == 1 && i % 2 != 0){
                sb.append(ch);
            }
        }
        if(sb.length() == 0){
            return EMPTY;
        }
        answer = sb.toString();
        return answer;
    }
}
