import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class day84 {
    /*
        숫자 카드 나누기
        https://school.programmers.co.kr/learn/courses/30/lessons/135807
     */
    public static void main(String[] args) {

    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int gcd = gcd(arrayA);
        List<Integer> cds = new ArrayList<>();
        IntStream.rangeClosed(1, gcd)
                .filter(i -> gcd % i == 0)
                .forEach(i -> cds.add(i));

        return answer;
    }

    public static int gcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
