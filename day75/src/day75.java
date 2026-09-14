import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class day75 {
    /*
        디스크 컨트롤러
        https://school.programmers.co.kr/learn/courses/30/lessons/42627
     */
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.printf(""+solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        int time = 0;
        int taskIdx = 0;
        int cnt = 0;

        while(cnt < jobs.length) {
            while (taskIdx < jobs.length && jobs[taskIdx][0] <= time) {
                queue.offer(jobs[taskIdx++]);
            }

            if (queue.isEmpty()) {
                time = jobs[taskIdx][0];
            } else {
                int[] task = queue.poll();
                cnt++;
                answer += task[1] + time - task[0];
                time += task[1];
            }

        }

        // total time
        return (int) Math.floor(answer / jobs.length);
    }
}
