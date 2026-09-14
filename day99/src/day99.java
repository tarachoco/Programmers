import java.util.ArrayList;
import java.util.Arrays;

public class day99 {
    /*
        GPS
        https://school.programmers.co.kr/learn/courses/30/lessons/1837
     */
    public static void main(String[] args) {
        int n = 7;
        int m = 10;
        int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
        int k = 6;
        int[] gps_log = {1, 2, 3, 3, 5, 7};
        System.out.printf(""+solution(n, m, edge_list, k, gps_log));
    }

    /*
        최적의 해를 구해야하므로 완전 탐색이다.

     */
    public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;

        ArrayList<Integer>[] graph = new ArrayList[n+1];

        int[][] dp = new int[k][n+1];
        for (int[]  d : dp) {
            Arrays.fill(d, n+1);
        }

        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edge_list) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // 초기값 셋팅
        for (int[] d : dp) {
            Arrays.fill(d, n+1);
        }

        dp[0][gps_log[0]] = 0;

        for (int i=0; i<k-1; i++) { // 시작 위치 인덱스
            for (int j=1; j<=n; j++) { // 다음 지점
                if (dp[i][j] == n+1) {
                    continue;
                }

                for (int next : graph[j]) {
                    int sub = gps_log[i+1] != next ? 1 : 0;
                    dp[i+1][next] = Math.min(dp[i+1][next],dp[i][j]+sub);
                }
            }
        }

        if (dp[k-1][gps_log[k-1]] != n+1) {
            answer = dp[k-1][gps_log[k-1]];
        } else {
            answer = -1;
        }
        return answer;
    }
}
