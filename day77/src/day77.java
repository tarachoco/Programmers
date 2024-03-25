import javafx.util.Pair;
import java.util.*;

public class day77 {
    /*
        단어 변환
        https://school.programmers.co.kr/learn/courses/30/lessons/43163
    */
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.printf(""+solution(begin, target, words));
    }

    static Map<String, List<String>> graph;

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        if (!Arrays.asList(words).contains(target)) {
            return answer;
        }

        Queue<Pair<String, Integer>> queue = new PriorityQueue<>(
                Comparator.comparingInt(value -> value.getValue()));
        queue.offer(new Pair<>(begin, 0));

        Map<String, Boolean> visited = new HashMap<>();

        while (!queue.isEmpty()) {
            Pair<String, Integer> w = queue.poll();

            if (target.equals(w.getKey())) {
                answer = w.getValue();
                break;
            }

            for (String word : words) {
                if (!visited.getOrDefault(word, false)) {
                    if (checkConvertible(w.getKey(), word)) {
                        queue.offer(new Pair<>(word, w.getValue() + 1));
                        visited.put(word, true);
                    }
                }
            }
        }

        return answer;
    }

    public static boolean checkConvertible(String s1, String s2) {
        int count = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        return count == s1.length() - 1;
    }
}
