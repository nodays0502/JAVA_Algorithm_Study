import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {
    static class Building implements Comparable<Building>{
        int no, time, inCount;
        List<Integer> nextList = new ArrayList<>();

        Building(int no){
            this.no = no;
        }

        @Override
        public int compareTo(Building o) {
            return inCount == o.inCount ?
                time - o.time
                : inCount - o.inCount;
        }
    }

    static int N;
    static Building[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());

        buildings = new Building[N + 1];
        for (int i = 1; i < N + 1; i++) {
            buildings[i] = new Building(i);
        }

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildings[i].time = stoi(st.nextToken());
            int in;
            while((in = stoi(st.nextToken())) != -1){
                buildings[i].inCount++; // i번 건물에 필요한 이전 단계 건물 수
                buildings[in].nextList.add(i); // in 건물 지은 다음에 i 지어야함
            }
        }

        Queue<Building> pq = new PriorityQueue<>();
        // 지을 수 있는 건물 넣기
        for (int i = 1; i < N + 1; i++) {
            if(buildings[i].inCount == 0){
                pq.offer(buildings[i]);
            }
        }

        int[] times = new int[N + 1];
        int time = 0;
        while(!pq.isEmpty()){
            Building b = pq.peek();
            if(b.time == 0) {
                times[b.no] = time;
                pq.poll();
                for (int i : b.nextList) {
                    buildings[i].inCount--;
                    // 이전 건물 다지음
                    if (buildings[i].inCount == 0) {
                        pq.offer(buildings[i]);
                    }
                }
            }

            for (Building pb : pq) {
                pb.time--;
            }
            time++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
//            System.out.println(times[i]);
            sb.append(times[i]+"\n");
        }
        System.out.println(sb.toString());
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}