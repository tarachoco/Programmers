import java.util.Arrays;

public class day62 {
    /*
        인사고과
        https://school.programmers.co.kr/learn/courses/30/lessons/152995
     */
    public static void main(String[] args) {
        int scores[][] = {{2,2},{1,4},{3,2},{3,2},{2,1}}; // 4
        System.out.printf(""+solution(scores));
    }

    public static int solution(int[][] scores) {
        int answer = 0;
        int size = scores.length;
        int n = scores[0][0];
        int m = scores[0][1];

        // 근무 태도 점수가 같으면 동료 태도 점수 순으로 정렬한다.
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        int maxScore = scores[0][1];

        for(int i = 1; i<size; i++) {
            // 인센티브 못 받는 경우 체크 진행
           if (scores[i][1] < maxScore) {
               // 완호가 인센티브를 받지 못하는 경우
               if (scores[i][0] == n && scores[i][1] == m) {
                   return -1;
               }

               scores[i][0] = -1;
               scores[i][1] = -1;
           } else {
                maxScore = scores[i][1];
           }
        }

        // 두 점수의 합산으로 정렬한다.
        Arrays.sort(scores, (o1, o2) -> {
            return (o2[0] + o2[1]) - (o1[0] + o1[1]);
        });

        answer = 1;

        // 위 합산된 값 기준으로 완호보다 크면 answer을 더해준다.
        for(int i = 0; i<size; i++) {
            if (scores[i][0] + scores[i][1] > n + m) {
                answer ++;
            } else {
                break;
            }
        }

        return answer;
    }
}
