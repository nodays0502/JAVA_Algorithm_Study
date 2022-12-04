package Programmers.ETC;

public class 모음_제거 {
    private static final char[] collections = {'a','e','i','o','u'};
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < my_string.length() ; i++){
            boolean flag = false;
            char ch = my_string.charAt(i);
            for(int j = 0 ; j < collections.length ; j++){
                if(collections[j] == ch){
                    flag = true;
                    break;
                }
            }
            if(flag){
                continue;
            }
            sb.append(ch);
        }
        answer = sb.toString();
        return answer;
    }
}
