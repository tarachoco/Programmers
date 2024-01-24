import java.util.*;

public class day66 {
    /*
        강철 부대
        https://school.programmers.co.kr/learn/courses/30/lessons/132266
     */
    public static void main(String[] args) {
        // #1. 케이스
        int n = 3;
        int[][] roads = {{1, 2}, {2, 3}};
        int[] sources = {2, 3};
        int destination = 1;

        // #2. 케이스
//        int n = 5;
//        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
//        int[] sources = {1, 3, 5};
//        int destination = 5;
        
        Arrays.stream(solution(n, roads, sources, destination)).forEach(System.out::println);
    }

	static List<Integer>[] graph;
	static int[] result;

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList[n+1];
        result = new int[n+1];
        Arrays.fill(result, -1);

        for (int i=0 ;i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<sources.length; i++) {
            bfs( n, sources[i], destination);
            answer[i] = result[sources[i]];
        }

        return answer;
    }

    public static void bfs (int n, int source, int destination) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(source, 0));
        boolean[] visited = new boolean[n+1];
        visited[source] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();

            if (node.index == destination) {
                result[source] = node.count;
                break;
            }

            for (int linked : graph[node.index]) {
                if (!visited[linked] && result[source] < node.count) {
                    visited[linked] = true;
                    queue.offer(new Node(linked, node.count+1));
                }
            }
        }

    }

    public static class Node {
        int index;
        int count;

        Node (int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    /*
        dfs 풀이 코드
        시간 초과로 실패
     */
//    static boolean[] visited;
//	static List<Integer>[] graph;
//	static int[] dp;
//
//    public static int[] solutionDfs(int n, int[][] roads, int[] sources, int destination) {
//        int[] answer = new int[sources.length];
//
//        // 초기화
//        visited = new boolean[n+1];
//        graph = new ArrayList[n+1];
//        dp = new int[n+1];
//
//        Arrays.fill(dp, -1);
//
//        for (int i=0 ;i<n+1; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for (int[] road : roads) {
//            graph[road[0]].add(road[1]);
//            graph[road[1]].add(road[0]);
//        }
//
//        for (int s : sources) {
//            dfs(s, s, destination, -1);
//        }
//
//        for (int i=0; i<sources.length; i++) {
//            answer[i] = dp[sources[i]];
//        }
//
//        return answer;
//    }
//
//    public static void dfs(int n, int source, int destination, int count) {
//        count++;
//
//        if (destination == n) {
//            if (dp[source] > -1) {
//                dp[source] = Math.min(dp[source], count);
//            } else {
//                dp[source] = count;
//            }
//
//            return;
//        }
//
//        visited[n] = true;
//
//        for (int child : graph[n]) {
//            if (!visited[child]) {
//                dfs(child, source, destination, count);
//            }
//        }
//
//        visited[n] = false;
//    }
}
