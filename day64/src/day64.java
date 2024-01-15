public class day64 {

    /*
        연속 펄스 부분 수열의 합
        https://school.programmers.co.kr/learn/courses/30/lessons/161988
     */
    public static void main(String[] args) {
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        System.out.printf(""+solution(sequence));
    }

    public static long solution(int[] sequence) {
        long answer = 0;
        int max1 = sequence[0];
        int max2 = 0;

        for (int i=1; i<sequence.length; i++) {

            if (i%2 == 1) {

                if (max1 < max1 + sequence[i] * -1) {
                    max1 += sequence[i] * -1;
                } else {
                    answer = Math.max(answer, max1);
                    max1 = 0;
                }

                if (max2 < max2 + sequence[i] * 1) {
                    max2 += sequence[i] * 1;
                } else {
                    answer = Math.max(answer, max2);
                    max2 = 0;
                }

            } else {

                if (max1 < max1 + sequence[i] * 1) {
                    max1 += sequence[i] * 1;
                } else {
                    answer = Math.max(answer, max1);
                    max1 = 0;
                }

                if (max2 < max2 + sequence[i] * -1) {
                    max2 += sequence[i] * -1;
                } else {
                    answer = Math.max(answer, max2);
                    max2 = 0;
                }

            }

        }

        answer = Math.max(answer, max1);
        answer = Math.max(answer, max2);

        return answer;
    }
}
