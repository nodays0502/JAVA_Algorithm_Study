package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2776 {
    private static final int FOUND = 1;
    private static final int NOT_FOUND = 0;

    //    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int testCnt = Integer.parseInt(br.readLine());
//        StringBuffer sb = new StringBuffer();
//        for(int t = 0 ; t < testCnt ; t++){
//            int n = Integer.parseInt(br.readLine());
////            int[] num1 = new int[n];
//            Set<Integer> num = new HashSet<>();
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int i = 0 ; i < n ; i++){
//                num.add(Integer.parseInt(st.nextToken()));
//            }
//            int m = Integer.parseInt(br.readLine());
//            st = new StringTokenizer(br.readLine());
//            for(int i = 0 ; i < m ; i++){
//                int temp = Integer.parseInt(st.nextToken());
//                if(num.contains(temp)){
//                    sb.append(FOUND+"\n");
//                }else{
//                    sb.append(NOT_FOUND+"\n");
//                }
//            }
//        }
//        System.out.println(sb);
//    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int t = 0; t < testCnt; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] num = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int temp = Integer.parseInt(st.nextToken());
                int index = Arrays.binarySearch(num, temp);
                if (index >= 0) {
                    sb.append(FOUND + "\n");
                } else {
                    sb.append(NOT_FOUND + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
