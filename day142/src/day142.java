public class day142 {
    /*
        최대공약수와 최소공배수
        https://school.programmers.co.kr/learn/courses/30/lessons/12940
     */
    public static void main(String[] args) {
        int[] answer = solution(3, 12);
        System.out.printf(answer[0] + ", " + answer[1]);
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = getGCD(n, m);
        answer[1] = n * m / answer[0];

        return answer;
    }

    public static int getGCD(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return getGCD(m, n%m);
    }
}
