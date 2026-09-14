import java.util.Arrays;

public class day108 {
    /*
        자연수 뒤집어 배열로 만들기
        https://school.programmers.co.kr/learn/courses/30/lessons/12932
     */
    public static void main(String[] args) {
        int[] result = solution(12345);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] solution(long n) {
        int[] answer = new int[(int) Math.log10(n)+1];

        for (int i=0; i<answer.length; i++) {
            answer[i] = (int) (n % 10);
            n /= 10;
        }

        return answer;
    }
}
