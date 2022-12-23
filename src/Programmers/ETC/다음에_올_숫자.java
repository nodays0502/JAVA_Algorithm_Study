package Programmers.ETC;

public class 다음에_올_숫자 {
    public int solution(int[] common) {
        int answer = cal(common);
        return answer;
    }
    private int cal(int[] common){
        int diff = common[1] - common[0];
        int size = common.length;
        boolean flag = true;
        for(int i = 0 ; i < size -1 ; i++){
            if(common[i] + diff != common[i+1]){
                flag = false;
            }
        }
        if(flag){
            return common[size-1] + diff;
        }
        diff = common[1] / common[0];
        return common[size-1] * diff;
    }
}
