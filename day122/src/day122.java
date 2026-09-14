import java.util.Arrays;

public class day122 {
    /*
        정수 내림차순으로 배치하기
        https://school.programmers.co.kr/learn/courses/30/lessons/12933
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(118372));
    }

    public static long solution(long n) {
        long answer = 0;
        long[] arr = new long[(int)Math.log10(n)+1];

        for (int i=0; i<arr.length; i++) {
            arr[i] = n % 10;
            n = n / 10;
        }

        Arrays.sort(arr);

        for (int i=0; i<arr.length; i++) {
            answer += arr[i] * Math.pow(10,i);
        }

        return answer;
    }
}
