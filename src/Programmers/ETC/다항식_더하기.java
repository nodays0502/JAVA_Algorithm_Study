package Programmers.ETC;

public class 다항식_더하기 {
    public String solution(String polynomial) {
        String answer = cal(polynomial);
        return answer;
    }
    private static String cal(String polynomial){
        String[] temp = polynomial.split(" ");
        int xCnt = 0;
        int num = 0;
        // System.out.println(Arrays.toString(temp));
        for(String str : temp){
            if(str.equals("+")){
                continue;
            }
            if(str.charAt(str.length()-1) == 'x'){
                if(str.length() == 1){
                    xCnt++;
                }else{
                    xCnt += Integer.parseInt(str.substring(0,str.length()-1));
                }
            }else{
                num += Integer.parseInt(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(xCnt == 1){
            sb.append("x ");
        }else if(xCnt != 0){
            sb.append(xCnt+"x ");
        }
        if(num != 0){
            if(sb.length() != 0){
                sb.append("+ ");
            }
            sb.append(num);
        }else{
            sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }
}
