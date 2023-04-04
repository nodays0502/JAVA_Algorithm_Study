package Programmers.ETC;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔_대실 {
    private static class Reservation{
        int startTime;
        int endTime;
        public Reservation(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        int size = book_time.length;
        Arrays.sort(book_time,(o1,o2)->{
            return o1[0].compareTo(o2[0]);
        });
        Reservation[] reservations = new Reservation[size];
        for(int i = 0 ; i < size ; i++){
            String[] str = book_time[i];
            Reservation reservation = changeReservation(str);
            reservations[i] = reservation;
        }
        PriorityQueue<Reservation> pq = new PriorityQueue<>((o1,o2)->{
            return o1.endTime - o2.endTime;
        });
        for(int i = 0 ; i < size ; i++){
            if(!pq.isEmpty() && pq.peek().endTime <= reservations[i].startTime){
                pq.poll();
            }
            pq.offer(reservations[i]);
            answer = Math.max(answer,pq.size());
        }
        return answer;
    }
    private static Reservation changeReservation(String[] str){
        int startTime = strToTime(str[0]);
        int endTime = strToTime(str[1]) + 10;
        return new Reservation(startTime,endTime);
    }
    private static int strToTime(String str){
        String[] temp = str.split(":");
        int hour = Integer.parseInt(temp[0]);
        int min = Integer.parseInt(temp[1]);
        return hour * 60 + min;
    }
}
