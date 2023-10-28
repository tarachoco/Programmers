public class day41 {
    /*
        다음 큰 숫자
        https://school.programmers.co.kr/learn/courses/30/lessons/12911
     */
    public static void main(String[] args) {
        System.out.println(solution(78));
    }

    public static int solution(int n) {
        int answer = n;
        int bitCount = Integer.bitCount(n);

        while (true) {
            answer++;

            if (bitCount == Integer.bitCount(answer)) {
                break;
            }
        }

        return answer;
    }
}
