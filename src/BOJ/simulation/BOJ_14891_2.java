package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14891_2 {

    private static final int LEFT_INDEX = 6;
    private static final int RIGHT_INDEX = 2;
    private static final int CLOCK_DIR = 1;
    private static final int REVERSE_CLOCK_DIR = -1;
    private static final int[] SCORE = {1,2,4,8};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer>[] gears = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            gears[i] = new LinkedList<>();
            String command = br.readLine();
            for (int j = 0; j < 8; j++) {
                char ch = command.charAt(j);
                gears[i].add(Integer.parseInt(ch + ""));
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            moveGears(gears, number, dir);
        }
        int totalScore = 0;
        for(int i = 0 ; i < 4; i++){
            totalScore += SCORE[i] * gears[i].get(0);
        }
        System.out.println(totalScore);
    }

    private static void moveGears(LinkedList<Integer>[] gears, int number, int dir) {
        int[] gearDir = new int[4];
        gearDir[number] = dir;
        int now = number + 1;
        while (now < 4) {
            if (gears[now].get(LEFT_INDEX) != gears[now - 1].get(RIGHT_INDEX)) {
                gearDir[now] = -gearDir[now - 1];
                now++;
            }else{
                break;
            }
        }
        now = number - 1;
        while (now >= 0) {
            if (gears[now].get(RIGHT_INDEX) != gears[now + 1].get(LEFT_INDEX)) {
                gearDir[now] = -gearDir[now + 1];
                now--;
            }else{
                break;
            }
        }
        for(int i = 0 ; i < 4 ; i++){
            moveGear(gears[i],gearDir[i]);
        }
    }

    private static void moveGear(LinkedList<Integer> gear, int clockDir) {
        if (clockDir == CLOCK_DIR) {
            gear.offerFirst(gear.pollLast());
        } else if(clockDir == REVERSE_CLOCK_DIR){
            gear.offerLast(gear.pollFirst());
        }
    }
}
