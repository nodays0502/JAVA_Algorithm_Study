package Programmers.ETC;

public class 외계어_사전 {
    private static final int NOT_FOUND = 2;
    private static final int FOUND = 1;
    public int solution(String[] spell, String[] dic) {
        int answer = NOT_FOUND;
        int[] cnt = new int[26];
        for(String str : spell){
            char ch = str.charAt(0);
            int index = ch - 'a';
            cnt[index]++;
        }
        for(String str : dic){
            if(check(str,cnt)){
                System.out.println(str);
                answer = FOUND;
                break;
            }
        }
        return answer;
    }
    private boolean check(String str,int[] cnt){
        int[] temp = new int[26];
        int size = str.length();
        for(int i = 0 ; i < size ; i++){
            char ch = str.charAt(i);
            int index = ch - 'a';
            temp[index]++;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(temp[i] != cnt[i]){
                return false;
            }
        }
        return true;
    }
}
