package Programmers.ETC;

public class 가장_긴_팰린드룸 {
    public int solution(String s) {
        int answer = 1;
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = 0 ; j < s.length() ; j++){
                int prevIndex = i - j;
                int endIndex = i + j;
                if(prevIndex >= 0 && endIndex < s.length() && s.charAt(prevIndex) == s.charAt(endIndex)){
                    answer = Math.max(endIndex-prevIndex+1,answer);
                }else{
                    break;
                }
            }
        }
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = 0 ; j < s.length() ; j++){
                int prevIndex = i - j;
                int endIndex = i + 1 + j;
                if(prevIndex >= 0 && endIndex < s.length() && s.charAt(prevIndex) == s.charAt(endIndex)){
                    answer = Math.max(endIndex-prevIndex+1,answer);
                }else{
                    break;
                }
            }
        }
        return answer;
    }
}
