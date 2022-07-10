package Programmers.ETC;

public class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int size = name.length();
        int min = size -1;
        for(int i = 0 ; i < name.length() ; i++){
            answer += cal(name.charAt(i));
            int nextIndex = i + 1;
            while(nextIndex < size && name.charAt(nextIndex) == 'A'){
                nextIndex++;
            }
            min = Math.min(min, (i*2) + size - nextIndex);
            min = Math.min(min,(size - nextIndex)*2 + i);
        }
        answer += min;
        return answer;
    }
    private int cal(char nameCh){
        return Math.min(Math.abs(nameCh - 'A'), Math.abs(nameCh - 'Z') + 1);
    }
}
