import java.util.*;
import java.util.stream.IntStream;

public class day84 {
    /*
        숫자 카드 나누기
        https://school.programmers.co.kr/learn/courses/30/lessons/135807
     */
    public static void main(String[] args) {
        int[] A = {14, 35, 119};
        int[] B = {18, 30, 102};

        System.out.printf(""+solution(A, B));
    }

    /*
        A와 B 최대공약수를 구해 각 조건에 맞는 최대 값을 구한다.
     */
    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        // 배열의 최대공약수를 구한다.
        int gcdA = gcd(arrayA);
        int gcdB = gcd(arrayB);

        for ( int num:arrayB ) {
            if ( num%gcdA==0 ) {
                gcdA = 0;
                break;
            }
        }

       answer = Math.max(answer, gcdA);

        for ( int num:arrayA ) {
            if ( num%gcdB==0 ) {
                gcdB = 0;
                break;
            }
        }

       answer = Math.max(answer, gcdB);

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
