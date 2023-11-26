import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class daya51 {
    /*
        프로세스
        https://school.programmers.co.kr/learn/courses/30/lessons/42587
     */
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
            queue.add(priorities[i]);
        }

        int i=0;
        int l=0;

        while (true) {
            if (i==location){
                break;
            }
            int poll = queue.poll();
            if (queue.stream().filter(q->q > poll).findAny().orElse(0) > 0) {
                queue.offer(poll);
                i++;
            } else {
                queue.offer(0);
            }
            l++;
            if (l>=priorities.length) {
                l=0;
            }
        }

        return l;
    }
}
