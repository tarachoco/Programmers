import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class day112 {
    /*
        없는 숫자 더하기
        https://school.programmers.co.kr/learn/courses/30/lessons/86051
     */
    public static void main(String[] args) {
        int[] numbers = {5,8,4,0,6,7,9};
        System.out.printf(""+solution(numbers));
    }

    public static int solution(int[] numbers) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        Arrays.stream(numbers).forEach(n -> set.add(n));

        for (int i=1; i<=9; i++) {
            if (!set.contains(i)) {
                answer+=i;
            }
        }

        return answer;
    }
}
