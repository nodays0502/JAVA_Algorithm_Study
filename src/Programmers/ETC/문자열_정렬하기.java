package Programmers.ETC;

public class 문자열_정렬하기 {
    private static final int SIZE = 26;
    public String solution(String my_string) {
        String answer = "";
        int[] cnt = new int[SIZE];
        my_string = my_string.toLowerCase();
        for(int i = 0 ; i < my_string.length() ; i++){
            char ch = my_string.charAt(i);
            int index = ch - 'a';
            cnt[index]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < SIZE ; i++){
            char ch = (char)(i + 'a');
            for(int j = 0 ; j < cnt[i] ; j++){
                sb.append(ch);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
