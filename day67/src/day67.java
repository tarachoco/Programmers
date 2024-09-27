import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class day67 {
    /*
        가장 먼 노드
        https://school.programmers.co.kr/learn/courses/30/lessons/49189
     */
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.printf(""+solution( n, edge ));
    }

    static List<Integer>[] graph;
    static int[] results;
    static boolean[] visited;
    static int maxDepth;

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[edge.length+1];
        results = new int[edge.length+1];
        visited = new boolean[n+1];
        maxDepth = 0;

        for (int i=0; i<=edge.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] ed : edge) {
            graph[ed[1]].add(ed[0]);
            graph[ed[0]].add(ed[1]);
        }

        bfs(1);

        answer = results[maxDepth];

        return answer;
    }

    public static void bfs (int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 1));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            maxDepth = Math.max(node.depth, maxDepth);

            for (int linked : graph[node.index]) {
                if (!visited[linked]) {
                    visited[linked] = true;
                    results[node.depth + 1] += 1;
                    queue.offer(new Node(linked, node.depth + 1));
                }
            }
        }
    }

    public static class Node {
        int index;
        int depth;

        Node (int index, int depth) {
            this.index = index;
            this.depth = depth;
        }
    }
}
