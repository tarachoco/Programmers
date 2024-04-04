import java.util.Arrays;
import java.util.Comparator;

public class day78 {
    /*
        섬 연결하기
        https://school.programmers.co.kr/learn/courses/30/lessons/42861
     */
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.printf(""+solution(n, costs));
    }

    /*
        최소 스패닝 트리
        가중치가 없을 때 모든 정점을 최소 비용으로 연결할 수 있는 방법
        => 크루스칼 알고리즘을 사용해야한다.
        => 이때 같은 간선 그래프에 있는 걸 선택하면 안되는데, 이는 UNION FIND 로 체크해야한다.

        그래프 내에 간선이 적은 희소 그래프에는 크루스칼 알고리즘
        간선이 많이 존재하는 밀집 그래프는 프림 알고리즘을 사용한다. (PQ를 사용하며 다익스트라와 유사)
     */
    private static int[] parent;
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];

        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        // 가중치대로 정렬해야한다.
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        for (int i = 0; i < costs.length; i++) {
            // 부모 사이클을 판단한다.
            if(find( costs[i][0]) != find( costs[i][1])) {
                answer += costs[i][2];
                union( costs[i][0], costs[i][1]);
            }
        }
        return answer;
    }

    /* UNION-FIND 합집합 찾기 */
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
