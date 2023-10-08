import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class day30 {
    /*
        영어 끝말잇기
        https://school.programmers.co.kr/learn/courses/30/lessons/12981
     */
    public static void main(String[] args) {
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] result = solution(2, words);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> history = new HashSet<>();
        boolean ended = false;

        int turn = 0;
        char lastCharacter = words[0].charAt(0);
        while (!ended) {
            for (int i=0; i<n; i++) {
                int wordIndex = i+(n*turn);
                if ( wordIndex >= words.length) {
                    ended = true;
                    break;
                }
                String word = words[wordIndex];
                if (history.contains(word) || lastCharacter != word.charAt(0)) {
                    ended = true;
                    answer[1] = turn+1;
                    answer[0] = i+1;
                    break;
                } else {
                    history.add(word);
                    lastCharacter = word.charAt(word.length()-1);
                }
            }
            turn++;
        }

        return answer;
    }
}
