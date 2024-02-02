import java.util.Arrays;

public class day68 {
    /*
        순위
        https://school.programmers.co.kr/learn/courses/30/lessons/49191
     */
    public static void main(String[] args) {

    }

    static int[][] graph;

    public int solution(int n, int[][] results) {
        int answer = 0;
        
        graph = new int[n+1][n+1];
        Arrays.fill(graph, Integer.MAX_VALUE);

        // 플로이드 와샬 수행
        floyd(n);
        
        return answer;
    }

    /*
        k: 경유지
        i: 출발지
        j: 목적지

        출발지-목적지 간의 경로를 계산하여, 경유지를 포함하였을 때 거리가 더 작다면 갱신한다.
        graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);

        O^3 시간 복잡도지만 모든 경로를 다 계산할 수 있음.
     */
    public int floyd (int n) {
        int result = 0;

        // 경유지
		for (int k = 1; k <= n; k++) {
			// 출발지
			for (int i = 1; i <= n; i++) {
				//도착지
				for (int j = 1; j <= n; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}

        return result;
    }
}
