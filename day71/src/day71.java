import java.util.Collections;
import java.util.PriorityQueue;

public class day71 {
    /*
        야근 지수
        https://school.programmers.co.kr/learn/courses/30/lessons/12927
     */
    public static void main(String[] args) {
        int[] works = {4, 3, 3};
        int n = 4;
//        int[] works = {2, 1, 2};
//        int n = 1;
//        int[] works = {1, 1};
//        int n = 3;
        System.out.printf(""+solution(n, works));
    }

    public static long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (long w : works) {
            queue.offer(w);
        }

        for (int i=0; i<n; i++) {

            if (queue.isEmpty()) {
                break;
            }

            long work = queue.poll() - 1;

            if (work > 0) {
                queue.offer(work);
            }

        }

        while (!queue.isEmpty()) {
            long work = queue.poll();
            answer += Math.pow(work, 2);
        }

        return answer;
    }
}
