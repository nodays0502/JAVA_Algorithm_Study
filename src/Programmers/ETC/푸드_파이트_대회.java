package Programmers.ETC;

public class 푸드_파이트_대회 {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder prev = new StringBuilder();
        StringBuilder post = new StringBuilder();
        for(int i = 1; i < food.length ; i++){
            int num = food[i] / 2;
            for(int j = 0 ; j < num ; j++){
                prev.append(i);
                post.append(i);
            }
        }
        answer = prev.toString() +"0" + post.reverse().toString();
        return answer;
    }
}
