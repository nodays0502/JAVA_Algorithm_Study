package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5639 {
    private static final int MAX_SIZE = 10_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[MAX_SIZE+1];
        int index = 0;
        String str;
        while(true){
            str = br.readLine();
            if(str == null || str.equals("")){
                break;
            }
            input[index++] = Integer.parseInt(str);
        }
        postOrder(0,index-1,input);
    }

    private static void postOrder(int start, int end, int[] input) {
//        System.out.println(start+" "+end);
        if(start > end){
            return ;
        }
        int value = input[start];
        int index = start+1;
        while(index <= end){
            if(input[index] < value){
                index++;
            }else{
                break;
            }
        }
        postOrder(start+1,index-1,input);
        postOrder(index,end,input);
        System.out.println(value);
    }
}
