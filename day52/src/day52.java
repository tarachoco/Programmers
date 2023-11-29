import java.util.ArrayList;
import java.util.List;

public class day52 {
    /*
        하노이의 탑
        https://school.programmers.co.kr/learn/courses/30/lessons/12946
     */
    public static void main(String[] args) {
        int[][] answer = solution(2);
        System.out.println(answer);
    }

    static List<int[]> list = new ArrayList<>();

    public static int[][] solution(int n) {
        move(n, 1, 2, 3);
        return list.stream().toArray(int[][]::new);
    }

    public static void move (int n, int start, int mid, int end) {
        if (n == 0) {
            return;
        }
        // 1->3->2 로 이동시킨다.
        move (n-1, start, end, mid);
        list.add(new int[]{start, end});
        // 2->1->3 으로 이동시킨다.
        move(n-1, mid, start, end);
    }
}
