import java.util.*;

public class day60 {
    /*
        등대
        https://school.programmers.co.kr/learn/courses/30/lessons/133500
        모든 길이 이어져 있기 때문에 트리 dp 형태로 처리 가능
     */
    public static void main(String[] args) {
        int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
//        int[][] lighthouse = {{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}};
        System.out.printf(""+ solution(8, lighthouse));
    }

    static boolean[] visited;
	static List<Integer>[] graph;
	static int[][] dp;

    public static int solution(int n, int[][] lighthouse) {
        int answer = 0;

        // 초기화
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        dp = new int[n + 1][2];

        for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

        // 연결된 노드에 대한 정보를 담는다.
        for (int[] lh : lighthouse) {
            graph[lh[0]].add(lh[1]);
            graph[lh[1]].add(lh[0]);
        }

        // 1번부터 찾는다.
        dfs(1);

        answer = Math.min(dp[1][0], dp[1][1]);

        return answer;
    }

    public static void dfs(int x) {
        visited[x] = true;
        // 자신이 꺼져있을 때와 켜져있을 때 케이스를 각각 구한다.
        dp[x][0] = 0;
        dp[x][1] = 1;

        for (int child : graph[x]) {
            if (!visited[child]) {
                // 리프노드부터 찾는다.
                dfs(child);
                // 부모 노드가 꺼져 있으면 자식 노드는 반드시 켜져있어야한다.
                dp[x][0] += dp[child][1];
                // 부모 노드가 켜져 있으면 자식 노드는 꺼져 있을 수도 있고 켜져 있을 수도 있다.
                // 최소값을 가져와 더해준다.
                dp[x][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
