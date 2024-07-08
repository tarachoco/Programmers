import java.util.Arrays;
import java.util.PriorityQueue;

public class day111 {
    /*
        과일 장수
        https://school.programmers.co.kr/learn/courses/30/lessons/135808
     */
    public static void main(String[] args) {
//        int k = 3;
//        int m = 4;
//        int[] score = {1,2,3,1,2,3,1};
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.printf(""+solution(k, m, score));
    }
    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Arrays.stream(score).forEach(s-> queue.offer(s));

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            for (int i=0; i<m; i++) {
                min = Math.min(queue.poll(), min);
            }

            answer += min * m;

            if (queue.size() < m) {
                break;
            }
        }

        return answer;
    }
}
