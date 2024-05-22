import java.util.Arrays;

public class day87 {
    /*
        징검다리
        https://school.programmers.co.kr/learn/courses/30/lessons/43236
     */
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        System.out.printf(""+solution(distance, rocks, n));
    }

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0;
        int right = distance;

        Arrays.sort(rocks);

        while (left <= right) {
            // 바위 사이 간격을 이분탐색의 조건으로 두자
            int mid = (left + right) / 2;
            // 해당 간격이 포함되는 바위 개수 카운드
            int count = 0;
            // 이전 바위
            int prevRock = 0;
            for (int i=0; i<rocks.length; i++) {
                if (rocks[i] - prevRock < mid) {
                    count++;
                } else {
                    // 이전 바위 업데이트
                    prevRock = rocks[i];
                }
            }
            // distance에도 바위가 존재하므로 한번 더 체크
            if (distance - prevRock < mid) {
                count++;
            }

            if (count > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }
}
