import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class daya51 {
    /*
        프로세스
        https://school.programmers.co.kr/learn/courses/30/lessons/42587
     */
    public static void main(String[] args) {
//        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 2;
        int[] priorities = {2,1,3,2};
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
            queue.add(priorities[i]);
        }

        int i=0;
        int l=0;

        while (true) {

            int poll = queue.poll();

            if (queue.stream().filter(q->q > poll).findAny().orElse(0) > 0) {
                queue.offer(poll);
            } else {
                queue.offer(0);
                i++;
                if (l==location) {
                    return i;
                }
            }

            l++;

            if (l>=priorities.length) {
                l=0;
            }

        }
    }
}
