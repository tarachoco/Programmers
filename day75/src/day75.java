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
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.taskTime));
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        int time = 0;
        int taskIdx = 0;
        int nextAvailable = 0;
        int cnt = 0;

        while(cnt < jobs.length) {
            while (taskIdx < jobs.length && (jobs[taskIdx][0] <= time || queue.isEmpty())) {
                queue.offer(new Node(jobs[taskIdx][0], jobs[taskIdx][1]));
                taskIdx++;
            }

            if (nextAvailable <= time) {
                Node node = queue.poll();
                cnt++;
                answer += node.taskTime + time - node.startTime;
                nextAvailable = time + node.taskTime;
            }

            time++;
        }

        // total time
        return (int) Math.floor(answer / jobs.length);
    }

    public static class Node {
        int startTime;
        int taskTime;

        Node (int startTime, int taskTime) {
            this.startTime = startTime;
            this.taskTime = taskTime;
        }
    }
}
