import java.util.Arrays;

public class day90 {
    /*
        최고의 집합
        https://school.programmers.co.kr/learn/courses/30/lessons/12938
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(2, 8));
    }

    public static int[] solution(int n, int s) {

        if (s < n) {
            return new int[] {-1};
        }

        int sub = s % n;
        int[] answer = new int[n];

        Arrays.fill(answer, s/n);

        for (int i=0; i<sub; i++) {
            answer[n-i-1]++;
        }

        return answer;

    }
}
