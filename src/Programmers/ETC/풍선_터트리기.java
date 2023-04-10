package Programmers.ETC;

public class 풍선_터트리기 {
    private static final int MAX_VALUE = 1_000_000_000;
    public int solution(int[] a) {
        int answer = 0;
        int size = a.length;
        int[] leftMin = new int[size];
        int[] rightMin = new int[size];
        int min = MAX_VALUE;
        for(int i = 0 ; i < size ; i++){
            min = Math.min(min,a[i]);
            leftMin[i] = min;
        }
        min = MAX_VALUE;
        for(int i = size-1 ; i >= 0 ; i--){
            min = Math.min(min,a[i]);
            rightMin[i] = min;
        }
        for(int i = 0 ; i < size ; i++){
            if(i == 0 || i == size -1){
                answer++;
                continue;
            }
            // System.out.println(leftMin[i-1]+" "+ a[i]+ " "+ rightMin[i+1]);
            if(leftMin[i-1] < a[i] && rightMin[i+1] < a[i]){
                continue;
            }
            answer++;
        }
        return answer;
    }
}
