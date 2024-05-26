import java.util.Arrays;

public class day86 {
    /*
        입국심사
        https://school.programmers.co.kr/learn/courses/30/lessons/43238
     */
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10};
        System.out.printf(""+solution(n,times));
    }

    public static long solution(int n, int[] times) {

        Arrays.sort(times);

        long left = 0;
        // 입국 심사까지 걸리는 최댓값
        long right = (long) times[times.length-1] * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            // mid 시간에 심사 가능한 사람 수 계산
            for (int i=0; i<times.length; i++) {
                count += mid / times[i];
            }

            // 최대로 가능한 값 찾기위해 left, right 조정
            if (count < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}
