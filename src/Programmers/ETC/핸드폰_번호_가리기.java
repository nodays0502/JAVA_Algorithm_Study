package Programmers.ETC;

public class 핸드폰_번호_가리기 {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < phone_number.length() ; i++){
            if(phone_number.length() - i > 4){
                sb.append("*");
            }else{
                sb.append(phone_number.charAt(i));
            }
        }
        answer = sb.toString();
        return answer;
    }
}
