import java.util.ArrayList;
import java.util.List;

public class day61 {
    /*
        매출 하락 최소화
        https://school.programmers.co.kr/learn/courses/30/lessons/72416
     */
    public static void main(String[] args) {
//        int[] sales = {10, 10, 1, 1};
//        int[][] links = {{3,2}, {4,3}, {1,4}};

//        int[] sales = {5,6,5,3,4};
//        int[][] links = { {2,3}, {1,4}, {2,5}, {1,2} };

        int[] sales = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
        int[][] links = {{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};
        System.out.printf(""+solution(sales, links));
    }

    static List<Integer>[] graph;
    static int[][] dp;

    public static int solution(int[] sales, int[][] links) {
        int answer = 0;

        graph = new ArrayList[sales.length+1];
        dp = new int[sales.length+1][2];

        for (int i=1; i<=sales.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 연결된 노드 적재
        for (int[] li : links) {
            graph[li[0]].add(li[1]);
        }

        dfs(1, sales);

        answer = Math.min(dp[1][0], dp[1][1]);

        return answer;
    }

    public static void dfs(int x, int[] sales) {
        dp[x][0] = 0;
        dp[x][1] = sales[x-1];

        // 최소 비용 계산 전 child가 존재 하지 않다면 return;
        if (graph[x].size() == 0) {
            return;
        }

        int minCost = Integer.MAX_VALUE;

        for (int child : graph[x]) {
            dfs(child, sales);
            /*
                TODO : 최소비용 계산
                팀원 참여 안 하는 경우 : 팀장도 참여 안 하면 최소값 적재
                팀원 참여 하는 경우 : 팀장 참여 안 하면 다른 팀의 팀원이 참여함 고려 (제일 작은 비용의 직원을 넣는다)
             */
            // 팀원 있는 게 최소 비용 더 작을 때
            if (dp[child][0] > dp[child][1] ) {
                dp[x][0] += dp[child][1];
                dp[x][1] += dp[child][1];

                // 팀원이 있으면 0으로 초기화한다.
                minCost = 0;
            } else {
                dp[x][0] += dp[child][0];
                dp[x][1] += dp[child][0];

                // 팀원 중 제일 적은 비용의 cost를 구한다.
                minCost = Math.min(minCost, dp[child][1] - dp[child][0]);
            }
        }

        // 팀장이 미참여라면 팀원 중 제일 적은 비용 직원의 cost를 넣는다.
        dp[x][0] += minCost;
    }
}
