package Programmers.ETC;

public class n2_배열_자르기 {
    public int[] solution(int n, long left, long right) {
        int grap = (int)(right - left);
        int[] answer = new int[grap + 1];
        long startY = left / n;
        long startX = left % n;
        long endY = right / n;
        long endX = right % n;
        long[] start = new long[] {startY,startX};
        int index = 0;
        while(true){
            // System.out.println(Arrays.toString(start));
            // System.out.println(findValue(start,n));
            answer[index++] = findValue(start,n);
            if(start[0] ==endY && start[1] == endX){
                break;
            }
            nextPosition(start,n);
        }
        return answer;
    }
    private void nextPosition(long[] position,int n){
        position[1]++;
        if(position[1] >= n){
            position[1] = 0;
            position[0]++;
        }
    }
    private int findValue(long[] position,int n){
        int value = (int)Math.max(position[0],position[1]);
        return value + 1;
    }
}
