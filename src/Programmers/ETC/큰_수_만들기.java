package Programmers.ETC;

public class 큰_수_만들기 {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder(number);
        int cnt = 0;
        for(int i = 1 ; i < sb.length() ; i++){
            char prev = sb.charAt(i-1);
            char now = sb.charAt(i);
            if(prev < now){
                sb.deleteCharAt(i-1);
                if(++cnt >= k){
                    break;
                }
                i = Math.max(i-2,0);
            }
        }
        while(cnt < k){
            sb.deleteCharAt(sb.length()-1);
            cnt++;
        }
        answer = sb.toString();
        return answer;
    }
}
