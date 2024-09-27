import java.util.PriorityQueue;

public class day137 {
    /*
        문자열 내림차순으로 배치하기
        https://school.programmers.co.kr/learn/courses/30/lessons/12917
     */
    public static void main(String[] args) {
        System.out.printf(solution("Zbcdefg")); // gfedcbZ
    }
    public static String solution(String s) {
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i=0; i<s.length(); i++) {
            queue.offer(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }
}
