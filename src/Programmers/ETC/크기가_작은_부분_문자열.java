package Programmers.ETC;

public class 크기가_작은_부분_문자열 {
    public int solution(String t, String p) {
        int answer = 0;
        int size = p.length();
        long pNum = Long.parseLong(p);
        for(int i = 0 ; i < t.length() - size + 1 ; i++){
            String temp = t.substring(i,i+size);
            long num = Long.parseLong(temp);
            if(pNum >= num){
                answer++;
            }
        }
        return answer;
    }
}
