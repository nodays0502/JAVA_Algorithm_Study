package Programmers.ETC;

public class 두_수의_합_1 {
    public String solution(String a, String b) {
        String answer = cal(a,b);
        return answer;
    }
    private static String cal(String a, String b){
        StringBuilder sb = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int prevTemp = 0;
        while(aIndex >= 0 || bIndex >= 0){
            int temp = prevTemp;
            if(aIndex >= 0){
                temp += Integer.parseInt(a.charAt(aIndex)+"") ;
            }
            if(bIndex >= 0){
                temp += Integer.parseInt(b.charAt(bIndex)+"");
            }
            sb.append(temp % 10);
            prevTemp = temp / 10;
            aIndex--;
            bIndex--;
        }
        if(prevTemp != 0){
            sb.append(prevTemp);
        }
        return sb.reverse().toString();
    }
}
