import java.util.Arrays;

public class day64 {

    /*
        연속 펄스 부분 수열의 합
        https://school.programmers.co.kr/learn/courses/30/lessons/161988
     */
    public static void main(String[] args) {
        int[] sequence = {0, -1};
        System.out.printf(""+solution(sequence));
    }

    public static long solution(int[] sequence) {
        long answer = 0;
        long max1 = 0;
        long max2 = 0;
        boolean flag = true;

        for (int num: sequence) {
            max1 += flag ? num : num * -1;
            max2 += flag ? num * -1 : num;

            // 음수가 나오면 0으로 초기화
            max1 = Math.max(0, max1);
            max2 = Math.max(0, max2);

            answer = Math.max(answer, Math.max(max1, max2));

            flag = !flag;
        }

        if (answer == 0) {
            Arrays.sort(sequence);
            answer = sequence[0];
        }

//        for (int i=1; i<sequence.length; i++) {
//
//            if (i%2 == 1) {
//
//                if (max1 < max1 + sequence[i] * -1) {
//                    max1 += sequence[i] * -1;
//                } else {
//                    answer = Math.max(answer, max1);
//                    max1 = 0;
//                }
//
//                if (max2 < max2 + sequence[i] * 1) {
//                    max2 += sequence[i] * 1;
//                } else {
//                    answer = Math.max(answer, max2);
//                    max2 = 0;
//                }
//
//            } else {
//
//                if (max1 < max1 + sequence[i] * 1) {
//                    max1 += sequence[i] * 1;
//                } else {
//                    answer = Math.max(answer, max1);
//                    max1 = 0;
//                }
//
//                if (max2 < max2 + sequence[i] * -1) {
//                    max2 += sequence[i] * -1;
//                } else {
//                    answer = Math.max(answer, max2);
//                    max2 = 0;
//                }
//
//            }
//
//        }
//
//        answer = Math.max(answer, max1);
//        answer = Math.max(answer, max2);

        return answer;
    }
}
