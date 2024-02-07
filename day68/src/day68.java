import java.util.Arrays;

public class day68 {
    /*
        순위
        https://school.programmers.co.kr/learn/courses/30/lessons/49191
     */
    public static void main(String[] args) {
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int n = 5;

        System.out.printf(""+solution2(n, results));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];

        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
            graph[result[1]][result[0]] = -1;
        }

        // 경유지
		for (int k = 1; k <= n; k++) {
			// 출발지
			for (int i = 1; i <= n; i++) {
				//도착지
				for (int j = 1; j <= n; j++) {
					if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[i][j] = -1;
                    }
				}
			}
		}

        // 자신을 제외한 경쟁자들과의 승패를 알 수 있어야 순위를 매길 수 있음.
        for (int i=0; i<=n; i++) {
            int count = 0;
            for (int j=0; j<=n; j++) {
                if (graph[i][j] != 0) {
                    count++;
                }
            }

            if (count == n - 1) {
                answer++;
            }
        }

//        graph = new int[n+1][n+1];
//        for (int i=0; i<graph.length; i++) {
//            Arrays.fill(graph[i], Integer.MAX_VALUE);
//        }
//
//        // 플로이드 와샬 수행
//        floyd(n);
//
        return answer;
    }

    public static int solution2(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n+1][n+1];

        for (int[] result : results) {
            graph[result[0]][result[1]] = true;
        }

        // 경유지
		for (int k = 1; k <= n; k++) {
			// 출발지
			for (int i = 1; i <= n; i++) {
				//도착지
				for (int j = 1; j <= n; j++) {
					if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }

                    if (!graph[i][k] && !graph[k][j]) {
                        graph[i][j] = true;
                    }
				}
			}
		}

        // 자신을 제외한 경쟁자들과의 승패를 알 수 있어야 순위를 매길 수 있음.
        for (int i=0; i<=n; i++) {
            int count = 0;
            for (int j=0; j<=n; j++) {
                if (graph[i][j]) {
                    count++;
                }
            }

            if (count == n - 1) {
                answer++;
            }
        }

//        graph = new int[n+1][n+1];
//        for (int i=0; i<graph.length; i++) {
//            Arrays.fill(graph[i], Integer.MAX_VALUE);
//        }
//
//        // 플로이드 와샬 수행
//        floyd(n);
//
        return answer;
    }



//    static int[][] graph;

    /*
        k: 경유지
        i: 출발지
        j: 목적지

        출발지-목적지 간의 경로를 계산하여, 경유지를 포함하였을 때 거리가 더 작다면 갱신한다.
        graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);

        O^3 시간 복잡도지만 모든 경로를 다 계산할 수 있음.
     */
//    public static int floyd (int n) {
//        int result = 0;
//
//        // 경유지
//		for (int k = 1; k <= n; k++) {
//			// 출발지
//			for (int i = 1; i <= n; i++) {
//				//도착지
//				for (int j = 1; j <= n; j++) {
//					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
//				}
//			}
//		}
//
//        return result;
//    }
}
