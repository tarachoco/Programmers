public class day123 {
    /*
        자릿수 더하기
        https://school.programmers.co.kr/learn/courses/30/lessons/12931
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(987));
    }

    public static int solution(int n) {

        if (n < 10) {
            return n;
        }

        return n % 10 + solution(n/10);
    }
}
