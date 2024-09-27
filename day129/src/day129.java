public class day129 {
    /*
        짝수와 홀수
        https://school.programmers.co.kr/learn/courses/30/lessons/12937
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(3));
    }

    public static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
