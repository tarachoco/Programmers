import java.util.*;

public class day65 {
    /*
        등산코스 정하기
        https://school.programmers.co.kr/learn/courses/30/lessons/118669
     */
    public static void main(String[] args) {
        // #1. 케이스
        int n = 6;
        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1, 3};
        int[] summits = {5};

        // #2. 케이스
//        int n = 7;
//        int[][] paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
//        int[] gates = {1};
//        int[] summits = {2, 3, 4};

        // #3. 케이스
//        int n = 7;
//        int[][] paths = {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}};
//        int[] gates = {3, 7};
//        int[] summits = {1, 5};

        // #4. 케이스
//        int n = 5;
//        int[][] paths = {{1, 3, 10}, {1, 4, 20}, {2, 3, 4}, {2, 4, 6}, {3, 5, 20}, {4, 5, 6}};
//        int[] gates = {1, 2};
//        int[] summits = {5};

        Arrays.stream(solution(n, paths, gates, summits)).forEach(System.out::println);
    }

    private static List<List<Node>> graph;

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();


        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int start = path[0];
            int end = path[1];
            int dis = path[2];

            /*
                출발지 -> 다른 지점, 산봉우리  -> 다른 지점은 단방향으로 해야
                한번씩만 지나가도록 조건이 만족된다.
             */
            if (isContained(start, gates) || isContained(end, summits)) {
                graph.get(start).add(new Node(end, dis));
            } else if (isContained(end, gates) || isContained(start, summits)) {
                graph.get(end).add(new Node(start, dis));
            } else {
                // 그외 양방향 연결
                graph.get(start).add(new Node(end, dis));
                graph.get(end).add(new Node(start, dis));
            }
        } 

        return dijkstra(n, gates, summits);
    }

    private static int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<Node> queue = new LinkedList<>();

        // 각 노드 번호 별 최소 경로일 때의 가중치를 계산한다.
        int[] intensity = new int[n + 1];

        Arrays.fill(intensity, Integer.MAX_VALUE);

        // 출입구들을 queue에 넣어 계산을 시작한다.
        for (int gate : gates) {
            queue.add(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // 현재의 가중치가 저장된 가중치보다 커서 최소 갱신이 되지 않을 때 스킵
            if (node.distance > intensity[node.index]) {
                continue;
            }

            // 연결된 노드를 찾아
            for (Node linked : graph.get(node.index)) {

                // 해당 경로의 최대 intensity 구하고
                int dis = Math.max(intensity[node.index], linked.distance);

                // 연결된 노드까지 이동하는 모든 경로 중 최소 intensity 값을 가진 경로라면 업데이트 해준다.
                if (intensity[linked.index] > dis) {
                    intensity[linked.index] = dis;
                    queue.add(new Node(linked.index, dis));
                }

            }

        }

        int mountain = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        Arrays.sort(summits);

        // 가중치가 최소인 산봉우리 경로를 가져온다.
        for (int summit : summits) {
            if (intensity[summit] < min) {
                mountain = summit;
                min = intensity[summit];
            }
        }

        return new int[]{mountain, min};
    }

    private static boolean isContained(int n, int[] arrays) {
        for (int a : arrays) {
            if (n == a) return true;
        }

        return false;
    }

    private static class Node {
        int index;
        int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
