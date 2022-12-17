package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;

public class 로그인_성공 {
    private static final String SUCCESS_LOGIN = "login";
    private static final String DIFFERENT_PW = "wrong pw";
    private static final String NOT_FOUND_ID = "fail";
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        Map<String,String> map = new HashMap<>();
        init(map,db);
        if(map.containsKey(id_pw[0])){
            String pw = map.get(id_pw[0]);
            if(pw.equals(id_pw[1]) ){
                answer = SUCCESS_LOGIN;
            }else{
                answer = DIFFERENT_PW;
            }
        }else{
            answer = NOT_FOUND_ID;
        }
        return answer;
    }
    private void init(Map<String,String> map , String[][] db){
        for(String[] strArray : db) {
            map.put(strArray[0],strArray[1]);
        }
    }
}
