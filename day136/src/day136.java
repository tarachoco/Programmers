public class day136 {
    /*
        소수 찾기
        https://school.programmers.co.kr/learn/courses/30/lessons/12921
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(10));
    }

    public static int solution(int n) {
        int answer = 0;

        for (int i=2; i<=n; i++) {
            if (isPrime(i)) {
                answer++;
            }
        }

        return answer;
    }

    // 에라토스테네스 체
    public static boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
          if (n % i == 0) {
              return false;
          }
        }
        return true;
    }
}
