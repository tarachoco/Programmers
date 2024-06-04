import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.PriorityQueue;

public class day94 {
    /*
        셔틀버스
        https://school.programmers.co.kr/learn/courses/30/lessons/17678
     */
    public static void main(String[] args) {
//        int n = 1;
//        int t = 1;
//        int m = 5;
//        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
//        int n = 2;
//        int t = 10;
//        int m = 2;
//        String[] timetable = {"09:10", "09:09", "08:00"};
//        int n = 2;
//        int t = 1;
//        int m = 2;
//        String[] timetable = {"09:00", "09:00", "09:00", "09:00"};
//        int n = 1;
//        int t = 1;
//        int m = 1;
//        String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};
//        int n = 1;
//        int t = 1;
//        int m = 1;
//        String[] timetable = {"23:59"};
        int n = 10;
        int t = 60;
        int m = 45;
        String[] timetable = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
        System.out.printf(""+solution(n,t,m,timetable));
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (String time : timetable) {
            String[] split = time.split(":");
            int pt = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            queue.offer(pt);
        }

        int startTime = 9 * 60;
        int answerTime = 0;

        int mCount = 0;
        for (int i = 0; i < n; i++) {
            mCount = 0;
            while (!queue.isEmpty()) {
                int last = queue.poll();
                if (last <= startTime && mCount < m) {
                    mCount++;
                    answerTime = last - 1;
                } else {
                    queue.offer(last);
                    break;
                }
            }
            startTime += t;
        }

        if (mCount < m) {
            answerTime = startTime - t;
        }

        String hour = String.format("%02d", answerTime / 60);
        String minute = String.format("%02d", answerTime % 60);

        answer = hour + ":" + minute;

        return answer;
    }
}
