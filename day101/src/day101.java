import java.util.PriorityQueue;

public class day101 {
    /*
        가장 큰 수
        https://school.programmers.co.kr/learn/courses/30/lessons/42746
     */
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.printf(""+solution(numbers));
    }

    public static String solution(int[] numbers) {

        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (int i=0; i<numbers.length; i++) {
            queue.offer(String.valueOf(numbers[i]));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }

        String answer = sb.toString();

        return answer;
    }
}
