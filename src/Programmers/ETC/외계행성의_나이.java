package Programmers.ETC;

public class 외계행성의_나이 {
    public String solution(int age) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        while(age > 0){
            int num = age % 10;
            sb.append( (char)('a'+num) );
            age /= 10;
        }
        sb.reverse();
        answer = sb.toString();
        return answer;
    }
}
