import java.util.Arrays;

public class day83 {
    /*
        거스름돈
        https://school.programmers.co.kr/learn/courses/30/lessons/12907
    */
    public static void main(String[] args) {
        int n = 5;
        int[] money = {1,2,5};
        System.out.printf(""+solution(n, money));
    }

    static int result = 0;

    public static int solution(int n, int[] money) {

        /*
            dp
         */
        Arrays.sort(money);
        int[] dp = new int[n+1];

        // 하나의 종류로 만들 수 있는 케이스로 인해 1로 셋팅
        dp[0] = 1;
        for (int i = 0; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) {
                // 각 money[i]별 경우의 수를 계산해 더해주는 방식
                // money[i]가 1일 경우...
                // 1,1,1,1,1,1
                // money[i]가 2일 경우...
                // 1,1,2,2,3,3
                // money[i]가 5인 경우...
                // 1,1,2,2,3,4
                // 0,4까지의 값으로 ~1,5까지의 dp를 계산한다.
                // 0,3까지의 값으로 ~2,5까지의 dp를 계산한다.
                // 0,0까지의 값으로 ~5,5까지의 dp를 계산한다.
                dp[j] += dp[j - money[i]] % 1000000007;
            }
        }
        return dp[n];


        /*
            dfs
            효율성 문제로 dp로 재 풀이
         */
//        for (int m : money) {
//            dfs(n, m, 0, money);
//        }
//        answer = result % 1000000007;
//
//        return answer;
    }

    public static void dfs(int n, int prev, int sum, int[] money) {

        if (n == sum) {
            result++;
            return;
        }

        if (sum > n) {
            return;
        }

        for (int m : money) {
            if (m < prev) {
                continue;
            }
            sum = sum + m;
            dfs(n, m, sum, money);
        }
    }

}
