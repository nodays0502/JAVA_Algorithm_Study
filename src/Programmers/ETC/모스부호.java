package Programmers.ETC;

public class 모스부호 {
    public String solution(String letter) {
        String answer = "";
        Map<String,Character> map = new HashMap<>();
        init(map);
        StringBuilder sb = new StringBuilder();
        String[] temp = letter.split(" ");
        for(String str : temp){
            sb.append(map.get(str));
        }
        answer = sb.toString();
        return answer;
    }
    private static void init(Map<String,Character> map){
        map.put(".-",'a');
        map.put("-...",'b');
        map.put("-.-.",'c');
        map.put("-..",'d');
        map.put(".",'e');
        map.put("..-.",'f');
        map.put("--.",'g');
        map.put("....",'h');
        map.put("..",'i');
        map.put(".---",'j');
        map.put("-.-",'k');
        map.put(".-..",'l');
        map.put("--",'m');
        map.put("-.",'n');
        map.put("---",'o');
        map.put(".--.",'p');
        map.put("--.-",'q');
        map.put(".-.",'r');
        map.put("...",'s');
        map.put("-",'t');
        map.put("..-",'u');
        map.put("...-",'v');
        map.put(".--",'w');
        map.put("-..-",'x');
        map.put("-.--",'y');
        map.put("--..",'z');
    }
}
