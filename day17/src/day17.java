import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class day17 {
    /*
        최댓값과 최솟값
        https://school.programmers.co.kr/learn/courses/30/lessons/12939?language=java
     */
    public static void main(String[] args) {
        String result = solution("-1 -1");
        System.out.println(result);
    }
    public static String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        Integer[] numbers = Arrays.stream(s.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }

        return min+" "+max;
    }
}
