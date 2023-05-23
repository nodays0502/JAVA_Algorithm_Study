package Programmers.ETC;

public class 배열_조각하기 {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = cal(arr, query);
        return answer;
    }

    private static int[] cal(int[] arr, int[] query){
        int startIndex = 0;
        int endIndex = arr.length - 1;
        for(int i = 0 ; i < query.length ; i++){
            if(i % 2 == 0) {
                endIndex = startIndex + query[i];
            }else {
                startIndex += query[i];
            }
            // System.out.println(i+" "+startIndex+" "+endIndex);
        }

        int size = endIndex - startIndex + 1;
        int[] answer = new int[size];
        for(int i = 0 ; i < size ; i++){
            answer[i] = arr[i + startIndex];
        }
        return answer;
    }
}
