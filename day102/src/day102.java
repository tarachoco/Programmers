import java.util.PriorityQueue;

public class day102 {
    /*
        디펜스 게임
        https://school.programmers.co.kr/learn/courses/30/lessons/142085
     */
    public static void main(String[] args) {
        int n = 2;
        int k = 4;
//        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        int[] enemy = {3, 3, 3, 3};
        System.out.printf(""+solution(n, k, enemy));
    }

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int right = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        while (right < enemy.length) {

            queue.offer(enemy[right]);
            n -= enemy[right];

            if (n < 0 && k > 0) {
                k--;
                n += queue.poll();
            }

            if (n < 0) {
                break;
            }

            right++;
        }

        answer = right;

        return answer;
    }
}
