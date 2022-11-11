package Programmers.ETC;

public class 컨트롤_제트 {
    public int solution(String s) {
        int answer = 0;
        String[] temp = s.split(" ");
        int sum = 0;
        boolean[] isNum = new boolean[temp.length];
        for(int i = 0 ; i < temp.length ; i++){
            if("Z".equals(temp[i])){
                int prevIndex = i-1;
                while(prevIndex >= 0 && !isNum[prevIndex]){
                    prevIndex--;
                }
                if(prevIndex < 0){
                    continue;
                }
                isNum[prevIndex] = false;
                int num = Integer.parseInt(temp[prevIndex]);
                sum -= num;
                continue;
            }
            isNum[i] = true;
            int num = Integer.parseInt(temp[i]);
            sum += num;
        }
        answer = sum;
        return answer;
    }
}
