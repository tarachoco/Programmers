import java.util.PriorityQueue;

public class day35 {
    /*
        더 맵게
        https://school.programmers.co.kr/learn/courses/30/lessons/42626
     */
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(scoville, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int s : scoville) {
            queue.add(s);
        }

        while (queue.peek() < K) {
            if (queue.size() == 1) {
                return -1;
            }
            queue.add(queue.poll() + (queue.poll() * 2));
            answer++;
        }

        return answer;
    }
}
