package Programmers.ETC;

public class 바탕화면_정리 {
    private static char EMPTY = '.';
    private static char FILE = '#';
    private static int MAX_VALUE = 51;
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int minY = MAX_VALUE;
        int maxY = 0;
        int minX = MAX_VALUE;
        int maxX = 0;
        for(int i = 0 ; i < wallpaper.length ; i++){
            for(int j = 0 ; j < wallpaper[0].length() ; j++){
                if(wallpaper[i].charAt(j) == FILE){
                    minY = Math.min(minY,i);
                    maxY = Math.max(maxY,i+1);
                    minX = Math.min(minX,j);
                    maxX = Math.max(maxX,j+1);
                }
            }
        }
        // System.out.println(minY+" "+minX+" "+maxY+" "+maxX);
        answer = new int[]{minY,minX,maxY,maxX};
        return answer;
    }
}
