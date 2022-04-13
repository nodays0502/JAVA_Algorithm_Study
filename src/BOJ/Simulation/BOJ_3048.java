package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_3048 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        String command1 = br.readLine();
        String command2 = br.readLine();
        int time = stoi.apply(br.readLine());
        StringBuilder sb = new StringBuilder();
        int size = command1.length() + command2.length();
        char[] result = new char[size];
        boolean[] group = new boolean[size];
        int index =0;
        for(int i = n-1 ; i >= 0 ; i--){
            result[index] = command1.charAt(i);
            group[index++] = true;
        }
        for(int i = 0 ; i < m ; i++){
            result[index++] = command2.charAt(i);
        }
        for(int t = 0 ; t < time ; t++){
            for(int i = 0 ; i < size ; i++){
                if(i < size-1 && group[i] && !group[i+1]){
                    swap(result,group,i,i+1);
                    i++;
                }
            }
        }
        System.out.println(result);
    }
    private static void swap(char[] result, boolean[] group,int a,int b){
        char temp = result[a];
        result[a] = result[b];
        result[b] = temp;
        boolean tempGroup = group[a];
        group[a] = group[b];
        group[b] = tempGroup;
    }
}
