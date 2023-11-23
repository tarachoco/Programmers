public class day49 {
    /*
        멀리 뛰기
        https://school.programmers.co.kr/learn/courses/30/lessons/72410
     */
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static long solution(int n) {
        long answer = 0;

        long[] d = new long[n+2];

        d[0] = 0;
        d[1] = 1;
        d[2] = 2;

        for (int i=3; i<=n; i++) {
            d[i] = (d[i-1] + d[i-2]) % 1234567;
        }

        return d[n];
    }
}
