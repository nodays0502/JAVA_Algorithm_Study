package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class BOJ_9375 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(br.readLine());
        for(int t = 0 ; t < test ; t++){
            List<String> list = new ArrayList<>();
            Map<String,Integer> map = new HashMap<>();
            int n = stoi.apply(br.readLine());
            for(int i = 0 ; i < n ; i++){
                String[] command = br.readLine().split(" ");
                if(!list.contains(command[1])){
                    list.add(command[1]);
                }
                map.merge(command[1],2,(o1,o2)->{return o1+1;});
            }
            int result = 1;
            if(map.size() != 0){
                result = map.get(list.get(0));
            }
            for(int i = 1 ; i < list.size(); i++){
                result *= map.get(list.get(i));
            }
            System.out.println(result - 1);
        }
    }
}
