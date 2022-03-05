package Programmers.KAKAO_INTERN_2021;

public class 숫자_문자열과_영단어 {
    /*
zero , one , two , three , four , five , six , seven , eight , night
*/
    private static String[] numberToString = {
        "zero" , "one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine"
    };
    private static int cal(String s){
        int result = 0;
        for(int i = 0 ; i < s.length() ;i++){
            // System.out.println(i);
            char now = s.charAt(i);
            result *= 10;
            if(now >= '0' && now <= '9'){
                result += now-'0';
                continue;
            }
            for(int j = 0 ; j < 10; j++){
                int length = numberToString[j].length();
                if(i + length <= s.length()){
                    String str = s.substring(i, i+length);
                    if(str.equals(numberToString[j])){
                        result += j;
                        i += (length - 1);
                        break;
                    }
                }
            }
        }
        return result;
    }
    public int solution(String s) {
        int answer = cal(s);
        return answer;
    }
}
