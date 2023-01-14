package Programmers.ETC;

public class 잘러서_배열로_저장하기 {
    public String[] solution(String my_str, int n) {
        int size = my_str.length()/n;
        if(my_str.length() % n != 0){
            size++;
        }
        String[] answer = new String[size];
        int index = 0;
        for(int i = 0 ; i < my_str.length() ; ){
            int next = Math.min(i+n,my_str.length());
            answer[index] = my_str.substring(i,next);
            i += n;
            index++;
        }
        return answer;
    }
}
