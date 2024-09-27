import javafx.util.Pair;
import java.util.*;

public class day80 {
    
    /*
        숫자 타자 대회
        https://school.programmers.co.kr/learn/courses/30/lessons/136797

        1 2 3
        4 5 6
        7 8 9
        * 0 #

     */
    public static void main(String[] args) {
//        String numbers = "1756";
//        String numbers = "5123";
        String numbers = "09876543210";
        //numbers 는 아라비아 숫자만 들어온다... 특문 고려 안해도 됨..
        System.out.printf(solution2(numbers)+"");
    }

    static List<Pair<Integer, Integer>>[] graph;
    public static int[][][] dp;
    public static int solution2(String numbers) {
        int answer = 0;
        int[][] key = {{1,2,3},{4,5,6},{7,8,9},{11,10,12}};

        dp = new int[numbers.length()][13][13];
        graph = new ArrayList[13];

        for (int i=0; i<=12; i++) {
            graph[i] = new ArrayList<>();
        }

        // init cost 계산하기
        for (int i=0; i<=3; i++) {
            for (int j=0; j<=2; j++) {

                graph[key[i][j]].add(new Pair<>(key[i][j], 1));

                if (j-1 >= 0) {
                    graph[key[i][j]].add(new Pair<>(key[i][j-1], 2));
                }
                if (j+1 <= 2) {
                    graph[key[i][j]].add(new Pair<>(key[i][j+1], 2));
                }
                if (i-1 >= 0) {
                    graph[key[i][j]].add(new Pair<>(key[i-1][j], 2));
                }
                if (i+1 <= 3) {
                    graph[key[i][j]].add(new Pair<>(key[i+1][j], 2));
                }
                if (j-1 >= 0 && i-1 >= 0) {
                    graph[key[i][j]].add(new Pair<>(key[i-1][j-1], 3));
                }
                if (j+1 <= 2 && i+1 <= 3) {
                    graph[key[i][j]].add(new Pair<>(key[i+1][j+1], 3));
                }
                if (i-1 >= 0 && j+1 <= 2) {
                    graph[key[i][j]].add(new Pair<>(key[i-1][j+1], 3));
                }
                if (i+1 <= 3 && j-1 >= 0) {
                    graph[key[i][j]].add(new Pair<>(key[i+1][j-1], 3));
                }
            }
        }

        answer = dp(0, numbers,4, 6);

        return answer;
    }

    /*
        dp를 통해 왼손과 오른손을 이동 했을 때의 최소 비용을 계산하자
        왼손과 오른손은 같은 자리에 있을 수 없다
     */
    public static int dp(int index, String str, int left, int right) {

        // 기저 사례
        if (index == str.length()) {
            return 0;
        }

        // 방문 여부 체크
        if (dp[index][left][right] != 0) {
            return dp[index][left][right];
        }

        char ch = str.charAt(index);
        int number = ch - '0';
        int cost = Integer.MAX_VALUE;

        if (left != number) {
            cost = Math.min(cost, dp(index+1, str, left, number) + dijkstra(right, number));
        }

        if (right != number) {
            cost = Math.min(cost, dp(index+1, str, number, right) + dijkstra(left, number));
        }

        dp[index][left][right] = cost;

        return dp[index][left][right];
    }

    /*
        최소 가중치로 노드를 순회해야함.
        => 다익스트라로 start -> target 까지 비용을 계산하자
     */
    public static int dijkstra(int start, int number) {

        // 숫자 0이 10으로 들어가서 변환 필요..
        if (number == 0) {
            number = 10;
        }

        if (start == 0) {
            start = 10;
        }

        // 같은 번호인 경우 가중치는 1
        if (start == number) {
            return 1;
        }

        int[] dist = new int[13];
        boolean[] visited = new boolean[13];

        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>(
                Comparator.comparingInt(value -> value.getValue()));

        queue.offer(new Pair<>(start, 0));

        // 최소 갱신을 위해 max_value 셋팅
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();

            if (visited[pair.getKey()]) {
                continue;
            }

            visited[pair.getKey()] = true;

            for (Pair<Integer, Integer> next : graph[pair.getKey()]) {
                if (dist[next.getKey()] > dist[pair.getKey()] + next.getValue()) {
                    dist[next.getKey()] = dist[pair.getKey()] + next.getValue();

                    queue.offer(next);
                }
            }
        }

        return dist[number];
    }

//    static List<Pair<Integer, Integer>>[] graph;
//    static Map<Integer, Pair<Integer, Integer>> keypad;

//    public static int solution(String numbers) {
//        int answer = 0;
//        int[][] key = {{1,2,3},{4,5,6},{7,8,9},{11,10,12}};
//
//        graph = new ArrayList[13];
//        keypad = new HashMap<>();
//
//        for (int i=0; i<=12; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        // init
//        for (int i=0; i<=3; i++) {
//            for (int j=0; j<=2; j++) {
//
//                keypad.put(key[i][j], new Pair<>(i,j));
//                graph[key[i][j]].add(new Pair<>(key[i][j], 1));
//
//                if (j-1 >= 0) {
//                    graph[key[i][j]].add(new Pair<>(key[i][j-1], 2));
//                }
//                if (j+1 <= 2) {
//                    graph[key[i][j]].add(new Pair<>(key[i][j+1], 2));
//                }
//                if (i-1 >= 0) {
//                    graph[key[i][j]].add(new Pair<>(key[i-1][j], 2));
//                }
//                if (i+1 <= 3) {
//                    graph[key[i][j]].add(new Pair<>(key[i+1][j], 2));
//                }
//                if (j-1 >= 0 && i-1 >= 0) {
//                    graph[key[i][j]].add(new Pair<>(key[i-1][j-1], 3));
//                }
//                if (j+1 <= 2 && i+1 <= 3) {
//                    graph[key[i][j]].add(new Pair<>(key[i+1][j+1], 3));
//                }
//                if (i-1 >= 0 && j+1 <= 2) {
//                    graph[key[i][j]].add(new Pair<>(key[i-1][j+1], 3));
//                }
//                if (i+1 <= 3 && j-1 >= 0) {
//                    graph[key[i][j]].add(new Pair<>(key[i+1][j-1], 3));
//                }
//            }
//        }
//
//        int left = 4;
//        int right = 6;
//
//        for (int i=0; i<numbers.length(); i++) {
//            int tempLeft = dijkstra(left, numbers.charAt(i));
//            int tempRight = dijkstra(right, numbers.charAt(i));
//
//            // else if 추가 필요
//            if (tempLeft > tempRight) {
//                right = Integer.parseInt(String.valueOf(numbers.charAt(i)));
//                answer += tempRight;
//            } else {
//                left = Integer.parseInt(String.valueOf(numbers.charAt(i)));
//                answer += tempLeft;
//            }
//        }
//
//        return answer;
//    }
//
}
