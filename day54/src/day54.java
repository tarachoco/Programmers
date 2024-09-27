import java.util.Arrays;

public class day54 {
    /*
        n^2 배열 자르기
        https://school.programmers.co.kr/questions/42681
     */
    public static void main(String[] args) {
        Arrays.stream(solution(3, 2, 5)).forEach(System.out::println);
    }

    public static int[] solution(int n, long left, long right) {

        int[] answer = new int[(int)(right - left) + 1];
        for (int i = 0; i < answer.length; i++) {
            int y = (int)(left / n + 1);
            int x = (int)(left % n + 1);
            left++;
            answer[i] = Math.max(y, x);
        }

        return answer;
    }
}
