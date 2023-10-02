public class day26 {
    /*
        숫자의 표현
        https://school.programmers.co.kr/learn/courses/30/lessons/12924/solution_groups?language=java
     */
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 1;

        for (int i=1; i<=n/2; i++) {
            int sum = 0;
            for (int j=i; sum <= n; j++) {
                sum += j;
                if (n == sum) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
