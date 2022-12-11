package Programmers.ETC;

public class 이진수_더하기 {
    public String solution(String bin1, String bin2) {
        String answer = "";
        int num1 = changeDec(bin1);
        System.out.println(num1);

        int num2 = changeDec(bin2);
        System.out.println(num2);

        answer = changeBin(num1+num2);
        return answer;
    }
    private int changeDec(String bin){
        int result = 0;
        for(int i = 0 ; i < bin.length() ; i++){
            result *= 2;
            result += bin.charAt(i) - '0';
        }
        return result;
    }
    private String changeBin(int num){
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            if(num % 2 == 0){
                sb.append(0);
            }else{
                sb.append(1);
            }
            num /= 2;
        }
        sb.reverse();
        if(sb.length() == 0){
            sb.append(0);
        }
        return sb.toString();
    }
}
