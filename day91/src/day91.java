import java.util.Arrays;

public class day91 {
    /*
        숫자 게임
        https://school.programmers.co.kr/learn/courses/30/lessons/12987
     */
    public static void main(String[] args) {
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};
        System.out.printf(""+solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i=0; i<B.length; i++) {
            if (A[answer] < B[i]) {
                answer++;
            }
        }

        return answer;
    }
}
