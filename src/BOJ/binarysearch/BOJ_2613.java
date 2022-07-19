package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2613 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        binarySearch(input,n,m);
    }
    private static final int INF = 300 * 100;
    private static final List NOT_FOUND = null;
    private static void binarySearch(int[] input, int n, int m) {
        int start = 0;
        int end = INF;
        List<Integer> result = new LinkedList();
        int minMaxValue = 0;
        while(start <= end){
            int mid = (start + end)/2;
//            System.out.println(mid);
            List temp = checkDivideGroup(mid,input,n,m);
            if(temp == NOT_FOUND){
                start = mid + 1;
            }else{
                minMaxValue = mid;
                result = temp;
                end = mid - 1;
            }
        }
        System.out.println(minMaxValue);
        for(int num : result){
            System.out.print(num+" ");
        }
    }

    private static List checkDivideGroup(int mid, int[] input, int n, int m) {
        int groupCnt = 0;
        int sum = 0;
        List<Integer> list = new LinkedList<>();
        for(int i = 0 ; i < input.length ; i++){
            int num = input[i];
            if(num > mid){
                return NOT_FOUND;
            }
            sum += num;
            if(mid < sum){
                sum = num;
                list.add(groupCnt);
                groupCnt = 1;
                continue;
            }
            groupCnt++;
        }
        list.add(groupCnt);
        if(m < list.size()){
            return NOT_FOUND;
        }
        while(list.size() < m){
//            System.out.println(list);
            for(int i = 0 ; i < list.size() ; i++){
                if(list.get(i) > 1){
                    int num = list.get(i);
                    list.add(i,1);
                    list.add(i,num-1);
                    list.remove(i+2);
                    break;
                }
            }
        }
        return list;
    }
}
