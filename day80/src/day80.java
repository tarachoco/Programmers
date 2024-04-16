import javafx.util.Pair;
import jdk.nashorn.internal.ir.annotations.Ignore;

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
        String numbers = "5123";
        System.out.printf(solution(numbers)+"");
    }

    /*
        최소 가중치로 노드를 순회해야함.
        => 다익스트라로 비용을 계산하자
        => dp로 각 비용을 계산해둬도 좋다.
     */
    static List<Pair<Integer, Integer>>[] graph;
    static Map<Integer, Pair<Integer, Integer>> keypad;

    public static int solution(String numbers) {
        int answer = 0;
        int[][] key = {{1,2,3},{4,5,6},{7,8,9},{11,10,12}};

        graph = new ArrayList[13];
        keypad = new HashMap<>();

        for (int i=0; i<=12; i++) {
            graph[i] = new ArrayList<>();
        }

        // init
        for (int i=0; i<=3; i++) {
            for (int j=0; j<=2; j++) {

                keypad.put(key[i][j], new Pair<>(i,j));
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

        int left = 4;
        int right = 6;

        // dijkstra안에서 오른쪽과 왼쪽을 비교하여 최소 가중치를 판단하자
        for (int i=0; i<numbers.length(); i++) {
            int tempLeft = dijkstra(left, numbers.charAt(i));
            int tempRight = dijkstra(right, numbers.charAt(i));

            if (tempLeft > tempRight) {
                right = Integer.parseInt(String.valueOf(numbers.charAt(i)));
                answer += tempRight;
            } else {
                left = Integer.parseInt(String.valueOf(numbers.charAt(i)));
                answer += tempLeft;
            }
        }

        return answer;
    }

    public static int dijkstra(int start, char target) {

        // 같은 번호인 경우 가중치는 1
        if (start == Integer.parseInt(String.valueOf(target))) {
            return 1;
        }

        int number = 0;

        if (target == '0') {
            number = 10;
        } else if (target == '*') {
            number = 11;
        } else if (target == '#') {
            number = 12;
        } else {
            number = Integer.parseInt(String.valueOf(target));
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
}
