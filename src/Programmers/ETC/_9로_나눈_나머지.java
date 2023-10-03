package Programmers.ETC;

public class _9로_나눈_나머지 {
    public int solution(String number) {
        int sum = 0;
        for(int i = 0 ; i < number.length() ; i++){
            sum += number.charAt(i) - '0';
        }
        int answer = sum % 9;
        return answer;
    }
}
