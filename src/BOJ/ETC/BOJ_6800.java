package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_6800 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        Map<String,String> map = new HashMap<>();
        for(int i = 0 ;i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            String Alpha = st.nextToken(); // A
            String temp = st.nextToken(); // 00
            map.put(temp,Alpha); // (00 , A) , (01,B) , (10,C) , (110,D) ....
        }
        String command = br.readLine(); // 111
        String result = "";
        for(int i = 0 ; i < command.length() ; i++){
            for(int j = i+1 ; j <= command.length() ; j++){
                String sub = command.substring(i,j); //
                if(map.containsKey(sub)){
                    result += map.get(sub);
                    i = j-1;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
