import java.util.ArrayList;
import java.util.List;

public class day127 {
    /*
        양과 늑대
        https://school.programmers.co.kr/learn/courses/30/lessons/92343
     */
    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

//        int[] info = {0,1,0,1,1,0,1,0,0,1,0};
//        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};

        System.out.printf(""+solution(info, edges));
    }

    static List<Integer>[] graph;
    static int result;

    /*
        DFS 변형 문제
        한번 탐색 노드를 다시 재탐색 해야하므로, 이에 대한 경로를 가지고 있어야함 (list)
        가공된 경로를 탐색하는 방식으로 bfs처럼 구현 가능
     */
    public static int solution(int[] info, int[][] edges) {
        int answer = 0;

        graph = new ArrayList[info.length];

        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        dfs(info, new int[]{0,1,0}, new ArrayList<>());

        answer = result;

        return answer;
    }

    public static void dfs(int[] info, int[] node, List<Integer> list) {

        // 양이 늑대보다 같거나 작으면 return;
        if (node[1] <= node[2]) {
            return;
        }

        result = Math.max(result, node[1]);

        // 부모 노드에서 연결된 노드 경로 탐색을 위해 전달받은 list 기반으로 신규 생성
        List<Integer> nextList = new ArrayList<>(list);

        // 자신과 연결된 경로를 nextList에 추가
        nextList.addAll(graph[node[0]]);

        // 자기 자신은 다음 경로에서 제거한다
        nextList.remove(Integer.valueOf(node[0]));

        for (Integer next : nextList) {
            int[] nextNode = {next, node[1], node[2]};

            if (info[next] == 0) {
                nextNode[1]++;
            } else {
                nextNode[2]++;
            }

            dfs(info, nextNode, nextList);
        }

    }
}
