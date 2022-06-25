package Programmers.ETC;

public class 가운데_글자_가져오기 {
    public String solution(String s) {
        String answer = "";
        int size = s.length();
        int halfIndex = size/2;
        if(size % 2 == 0){
            answer = s.substring(halfIndex-1,halfIndex+1);
        }else{
            answer = s.substring(halfIndex,halfIndex+1);
        }
        return answer;
    }
}
