package Programmers.ETC;

public class 문자열_밀기 {
    private static final int NOT_FOUND = -1;
    public int solution(String A, String B) {
        int answer = NOT_FOUND;
        int time = 0;
        int size = B.length();
        while(true){
            System.out.println(A);
            if(B.equals(A)){
                answer = time;
                break;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(A.charAt(size-1));
            sb.append(A);
            sb.setLength(size);
            A = sb.toString();
            time++;
            if(time > size){
                break;
            }
        }
        return answer;
    }
}
