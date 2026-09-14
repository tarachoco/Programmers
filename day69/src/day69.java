import java.util.*;

public class day69 {
    /*
        징검다리 건너기
        https://school.programmers.co.kr/learn/courses/30/lessons/64062
     */
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.printf(""+solution(stones, k));
    }

    /*
        파라매트릭 서치를 통해 처리가 필요하다.
        : 최적화 문제(문제의 상황을 만족하는 최솟값, 최댓값을 구하는 문제)를 결정 문제로 바꾸어 푸는 것
        : 즉, 특정 조건을 만족하냐 아니냐에 따라 해의 범위를 좁혀나가며 탐색을 진행한다.
     */
    public static int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int stone : stones) {
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }

        while (min < max) {
            int mid = (min + max + 1) / 2;

            // 건너지 못하는 사람이 생길 때까지 min을 mid로 변경하며 범위를 계속 좁혀나간다.
            if (checkToPeople(mid, k, stones)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return max;
    }

    public static boolean checkToPeople(int mid, int k, int[] stones) {
        int count = 0;
        for (int stone : stones) {
            if (stone - mid < 0) {
                // 연속으로 못 건너는 돌을 체크한다.
                count++;
            } else {
                // 건널 수 있는 돌이 생기면 count 리셋한다.
                count = 0;
            }

            if (count == k) {
                return false;
            }
        }
        return true;
    }
}
