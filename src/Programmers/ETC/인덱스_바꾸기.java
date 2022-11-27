package Programmers.ETC;

public class 인덱스_바꾸기 {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < my_string.length() ; i++){
            char ch = my_string.charAt(i);
            if(i == num1){
                sb.append(my_string.charAt(num2));
            }else if(i == num2){
                sb.append(my_string.charAt(num1));
            }else{
                sb.append(ch);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
