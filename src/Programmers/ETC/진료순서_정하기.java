package Programmers.ETC;

public class 진료순서_정하기 {
    public int[] solution(int[] emergency) {
        int size = emergency.length;
        int[] answer = new int[size];
        boolean[] used = new boolean[size];
        for(int i = 0 ; i < size ; i++){
            int index = -1;
            for(int j = 0 ; j < size ; j++){
                if(used[j]){
                    continue;
                }
                if(index == -1){
                    index = j;
                    continue;
                }
                if(emergency[index] < emergency[j]){
                    index = j;
                }
            }
            used[index] = true;
            answer[index] = i+1;
        }
        return answer;
    }
}
