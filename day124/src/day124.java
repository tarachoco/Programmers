public class day124 {
    /*
        약수의 합
        https://school.programmers.co.kr/learn/courses/30/lessons/12928
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(12));
    }

    public static int solution(int n) {
        int answer = 0;

        for (int i=1; i<=n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
