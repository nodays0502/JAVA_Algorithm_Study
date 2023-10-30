package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_12933 {
    private static final char[] QUACK = {'q','u','a','c','k'};
    private static final int NOT_FOUND = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean[] used = new boolean[str.length()];
        int[] index = findQuack(str,0,used);
        if(index[0] == NOT_FOUND || index[1] == NOT_FOUND){
            System.out.println(NOT_FOUND);
            return ;
        }
        LinkedList<int[]> list = new LinkedList<>();
        while(index[0] != NOT_FOUND && index[1] != NOT_FOUND){
            list.add(index);
            index = findQuack(str,index[0] + 1,used);
        }
        if(isError(used,str.length()) || (index[0] != NOT_FOUND && index[1] == NOT_FOUND) ){
            System.out.println(NOT_FOUND);
            return ;
        }
        int result = countQuack(list);
        System.out.println(result);
    }

    private static int countQuack(LinkedList<int[]> list) {
        Queue<int[]> prevList = new LinkedList<>();
        int maxCnt = 0;
        int cnt = 0;
        for(int[] index : list){
            maxCnt = Math.max(maxCnt,cnt);
            if(prevList.isEmpty()){
                prevList.offer(index);
                cnt++;
                continue;
            }
            if(prevList.peek()[0] < index[0] &&  index[0] < prevList.peek()[1]){
                prevList.offer(index);
                cnt++;
                continue;
            }
            // 위 조건이 아닌 경우
            while(!prevList.isEmpty() && prevList.peek()[1] < index[0]){
                prevList.poll();
                cnt--;
            }
        }
        maxCnt = Math.max(maxCnt,cnt);
        return maxCnt;
    }

    private static boolean isError( boolean[] used, int length) {
        for(int i = 0 ; i < length ; i++){
            if(!used[i]){
                return true;
            }
        }

        return false;
    }

    private static int[] findQuack(String str, int startIndex, boolean[] used) {
        int index = startIndex;
        int qIndex = NOT_FOUND;
        int kIndex = NOT_FOUND;
        for(int i = 0 ; i < QUACK.length ; i++){
            char word = QUACK[i];
            index = str.indexOf(word,index);
            while(index != NOT_FOUND && used[index]){
                index = str.indexOf(word,index+1);
            }
            if(index == NOT_FOUND){
                break;
            }
            if(i == 0){
                qIndex = index;
            }
            if(i == QUACK.length - 1){
                kIndex = index;
            }
            used[index] = true;
        }
        return new int[]{qIndex, kIndex};
    }
}
