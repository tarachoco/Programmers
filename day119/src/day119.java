import java.util.Arrays;

public class day119 {
    /*
        나누어 떨어지는 숫자 배열
        https://school.programmers.co.kr/learn/courses/30/lessons/12910
     */
    public static void main(String[] args) {
        int[] arr = {3,2,6};
        Arrays.stream(solution(arr, 10)).forEach(System.out::println);
    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(s->s%divisor == 0).sorted().toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }
}
