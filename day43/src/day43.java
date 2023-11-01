import java.util.*;

public class day43 {
    /*
        기능개발
        https://school.programmers.co.kr/learn/courses/30/lessons/42586
     */
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        Arrays.stream(solution(progresses, speeds)).forEach(System.out::println);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>(Arrays.asList());
        for (int i=0; i<progresses.length; i++) {
           queue.add(progresses[i]);
        }

        int idx = 0;
        int cnt = 1;
        int i = 0;
        while (!queue.isEmpty()) {
            if (queue.peek() + (cnt * speeds[idx]) >= 100) {
                queue.poll();
                idx++;
                i++;
                if (queue.isEmpty()) list.add(i);
            } else {
                if (i>0) list.add(i);
                cnt++;
                i = 0;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
