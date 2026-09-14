import java.util.Arrays;

public class day131 {
    /*
        x만큼 간격이 있는 n개의 숫자
        https://school.programmers.co.kr/learn/courses/30/lessons/12954
     */
    public static void main(String[] args) {
        Arrays.stream(solution(-4, 2)).forEach(System.out::println);
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i=0; i<n; i++) {
            answer[i] = (long) x * (i+1);
        }

        return answer;
    }
}
