package Programmers.ETC;

public class 진법_뒤집기 {

    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while( n > 0){
            sb.append(n%3);
            n /= 3;
        }
        // sb = sb.reverse();
        System.out.println(sb);
        int num = 1;
        for(int i = sb.length() - 1 ; i >= 0 ; i--){
            answer += Integer.parseInt(sb.charAt(i)+"") * num;
            num *= 3;
        }
        return answer;
    }
}
